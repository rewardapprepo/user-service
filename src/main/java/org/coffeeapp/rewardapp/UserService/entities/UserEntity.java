package org.coffeeapp.rewardapp.UserService.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity
{
	@Id
	@GeneratedValue
	private Long id;

	@Column( nullable = false, length = 50 )
	private String name;
	@Column( nullable = false, length = 120, unique = true )
	private String email;
	@Column( nullable = false, length = 50 )
	private String phone;
	@Column( nullable = false, length = 50 )
	private String country;
	@ElementCollection
	private List<Long> rewards;

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

	public List<Long> getRewards( )
	{
		return rewards;
	}

	public void setRewards( List<Long> rewards )
	{
		this.rewards = rewards;
	}
}
