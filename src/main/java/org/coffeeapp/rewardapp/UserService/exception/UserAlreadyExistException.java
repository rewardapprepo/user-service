package org.coffeeapp.rewardapp.UserService.exception;

public class UserAlreadyExistException extends RuntimeException
{
	public UserAlreadyExistException(String message)
	{
		super(message);
	}
}
