package org.coffeeapp.rewardapp.UserService.service;

import org.coffeeapp.rewardapp.UserService.model.AddRewardRequestModel;
import org.coffeeapp.rewardapp.UserService.model.UserResponseModel;
import org.coffeeapp.rewardapp.UserService.shared.UserDto;

import java.util.List;


public interface UserService
{
	UserDto createUser( UserDto userDto );

	UserResponseModel getUserDetailsById(Long id );

	List<UserDto> getUsersByRewardId( Long rewardId );

	void addRewardToUser( AddRewardRequestModel addRewardRequestModel );
}
