package org.coffeeapp.rewardapp.UserService.controller;

import org.coffeeapp.rewardapp.UserService.model.AddRewardRequestModel;
import org.coffeeapp.rewardapp.UserService.model.CreateUserRequestModel;
import org.coffeeapp.rewardapp.UserService.model.UserResponseModel;
import org.coffeeapp.rewardapp.UserService.service.UserService;
import org.coffeeapp.rewardapp.UserService.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping( "/users" )
public class UserController
{
	UserService userService;

	@Autowired
	public UserController( UserService userService )
	{
		this.userService = userService;
	}

	@PostMapping(
		consumes = { MediaType.APPLICATION_JSON_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<CreateUserRequestModel> createUser( @Valid @RequestBody CreateUserRequestModel createUserRequestModel )
	{
		ModelMapper modelMapper = new ModelMapper( );
		modelMapper.getConfiguration( ).setMatchingStrategy( MatchingStrategies.STRICT );

		UserDto userDTO = modelMapper.map( createUserRequestModel, UserDto.class );
		UserDto createdUser = userService.createUser( userDTO );

		CreateUserRequestModel returnValue = modelMapper.map( createdUser, CreateUserRequestModel.class );

		return ResponseEntity.status( HttpStatus.CREATED ).body( returnValue );
	}

	@GetMapping( value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<UserResponseModel> getUserById( @PathVariable( "id" ) Long id )
	{
		UserResponseModel userDetails = userService.getUserDetailsById( id );
		return ResponseEntity.status( HttpStatus.OK ).body( userDetails );
	}

	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<List<UserDto>> getUsersByRewardId( @RequestParam( "rewardId" ) Long rewardId )
	{
		return ResponseEntity.status( HttpStatus.OK ).body( userService.getUsersByRewardId( rewardId ) );
	}

	@PostMapping(
		value = "/add-reward",
		consumes = { MediaType.APPLICATION_JSON_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<UserResponseModel> addRewardToUser( @Valid @RequestBody AddRewardRequestModel addRewardRequestModel )
	{
		userService.addRewardToUser( addRewardRequestModel );

		return ResponseEntity.status( HttpStatus.CREATED ).body( null );
	}
}
