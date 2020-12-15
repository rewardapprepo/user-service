package org.coffeeapp.rewardapp.UserService.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel
{
	@NotNull( message = "Name should not be empty" )
	@Size(min=2, message = "Name size should be more than 1 character")
	private String name;

	@NotNull( message = "Phone should not be empty" )
	@Size(min=2, message = "Phone number size should be more than 1 character")
	private String phone;

	@NotNull( message = "Email should not be empty" )
	@Email(message = "Email should be valid")
	private String email;

	@NotNull( message = "Country should not be empty" )
	@Size(min=2, message = "Country size should be more than 1 character")
	private String country;

	public String getName( )
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getPhone( )
	{
		return phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public String getEmail( )
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getCountry( )
	{
		return country;
	}

	public void setCountry( String country )
	{
		this.country = country;
	}
}
