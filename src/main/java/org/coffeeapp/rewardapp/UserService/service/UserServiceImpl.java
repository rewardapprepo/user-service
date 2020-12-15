package org.coffeeapp.rewardapp.UserService.service;

import org.coffeeapp.rewardapp.UserService.entities.UserEntity;
import org.coffeeapp.rewardapp.UserService.exception.EntityNotFoundException;
import org.coffeeapp.rewardapp.UserService.exception.UserAlreadyExistException;
import org.coffeeapp.rewardapp.UserService.model.AddRewardRequestModel;
import org.coffeeapp.rewardapp.UserService.model.RewardResponseModel;
import org.coffeeapp.rewardapp.UserService.model.UserResponseModel;
import org.coffeeapp.rewardapp.UserService.repository.UserRepository;
import org.coffeeapp.rewardapp.UserService.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
	private final ModelMapper modelMapper;
	RewardServiceClient rewardServiceClient;
	UserRepository userRepository;

	@Autowired
	public UserServiceImpl( UserRepository userRepository, RewardServiceClient rewardServiceClient )
	{
		this.rewardServiceClient = rewardServiceClient;
		this.userRepository = userRepository;
		this.modelMapper = new ModelMapper( );
		this.modelMapper.getConfiguration( ).setMatchingStrategy( MatchingStrategies.STRICT );
	}

	@Override public UserDto createUser( UserDto userDto )
	{
		UserEntity user = userRepository.findByEmail( userDto.getEmail( ) );
		if ( user != null )
		{
			throw new UserAlreadyExistException( "User with " + userDto.getEmail( ) + " is already exist" );
		}
		UserEntity userEntity = modelMapper.map( userDto, UserEntity.class );
		UserEntity savedUser = userRepository.save( userEntity );
		return modelMapper.map( savedUser, UserDto.class );
	}

	@Override public UserResponseModel getUserDetailsById( Long id )
	{
		UserEntity user = userRepository.findById( id ).orElse( null );
		if ( user == null )
		{
			throw new EntityNotFoundException( UserEntity.class, "id", id.toString( ) );
		}
		UserResponseModel userResponseModel = modelMapper.map( user, UserResponseModel.class );
		List<RewardResponseModel> rewards = rewardServiceClient.getRewardsByUserId( id );
		userResponseModel.setRewards( rewards );
		return userResponseModel;
	}

	@Override public List<UserDto> getUsersByRewardId( Long rewardId )
	{
		List<UserEntity> usersByRewardId = userRepository.findByRewardsIn( Arrays.asList( rewardId) );
		List<UserDto> users = new ArrayList<>( );
		usersByRewardId.forEach( user -> {
			users.add( modelMapper.map( user, UserDto.class ) );
		} );

		return users;
	}

	@Override public void addRewardToUser( AddRewardRequestModel addRewardRequestModel )
	{
		UserEntity user = userRepository.findById( addRewardRequestModel.getUserId( ) ).orElse( null );
		if ( user == null )
		{
			throw new EntityNotFoundException( UserEntity.class, "id", addRewardRequestModel.getUserId( ).toString( ) );
		}
		List<Long> rewards = user.getRewards( );
		rewards.add( addRewardRequestModel.getRewardId( ) );
		user.setRewards( rewards );
		userRepository.save( user );
	}

}
