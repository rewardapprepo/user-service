package org.coffeeapp.rewardapp.UserService.model;

import java.util.Date;

public class RewardResponseModel
{
	//id, name, amount, expiry_date
	private Long id;
	private String name;
	private String amount;
	private Date expiryDate;

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

	public String getAmount( )
	{
		return amount;
	}

	public void setAmount( String amount )
	{
		this.amount = amount;
	}

	public Date getExpiryDate( )
	{
		return expiryDate;
	}

	public void setExpiryDate( Date expiryDate )
	{
		this.expiryDate = expiryDate;
	}
}
