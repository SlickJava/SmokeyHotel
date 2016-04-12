package com.smokeyhotel.people.guest;

import java.sql.Date;

import com.smokeyhotel.people.Person;

public class Guest extends Person{
	
	private String creditCardNumber;
	
	public Guest(int age, String name, String address, String suburb,
			String phone, String creditCardNumber) {
		super(age, name, address, suburb, phone);
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getCreditCardNumber()
	{
		return this.creditCardNumber;
	}
	
	public void setCreditCardNumber(String number)
	{
		this.creditCardNumber = number;
	}
	

}
