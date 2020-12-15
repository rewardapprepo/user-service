package org.coffeeapp.rewardapp.UserService.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.http.HttpStatus;
import org.coffeeapp.rewardapp.UserService.entities.UserEntity;

public class RewardClientException implements ErrorDecoder
{
	@Override public Exception decode( String s, Response response )
	{
		switch ( response.status( ) )
		{
		case HttpStatus
			.SC_NOT_FOUND:
			return new EntityNotFoundException( UserEntity.class, "id" + "id");
		default:
			return new EntityNotFoundException( UserEntity.class, "id" + "id");
		}
	}
}
