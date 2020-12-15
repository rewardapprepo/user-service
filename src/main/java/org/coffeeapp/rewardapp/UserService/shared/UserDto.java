package org.coffeeapp.rewardapp.UserService.shared;

public class UserDto
{
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String country;

	public Long getId( )
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

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
}
