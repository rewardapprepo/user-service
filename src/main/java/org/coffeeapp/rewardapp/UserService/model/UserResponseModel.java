package org.coffeeapp.rewardapp.UserService.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class UserResponseModel
{
	private String name;
	private String email;
	private String phone;
	private String country;
	List<RewardResponseModel> rewards;

	public String getName( )
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getEmail( )
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPhone( )
	{
		return phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public String getCountry( )
	{
		return country;
	}

	public void setCountry( String country )
	{
		this.country = country;
	}

	public List<RewardResponseModel> getRewards( )
	{
		return rewards;
	}

	public void setRewards( List<RewardResponseModel> rewards )
	{
		this.rewards = rewards;
	}
}
