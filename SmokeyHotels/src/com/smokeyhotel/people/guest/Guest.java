package com.smokeyhotel.people.guest;

import java.time.LocalDate;

import com.smokeyhotel.people.Person;

/**
 * Guest Object Class.
 * @author SlickJava & InsaneAboutTNT
 */

public class Guest extends Person{
	
	private String creditCardNumber;
	private long ID;
	
	/**
	 * Constructor:
	 * 
	 * @param age 
	 * @param name
	 * @param address 
	 * @param suburb 
	 * @param phone 
	 * @param creditCardNumber
	 */
	public Guest(LocalDate dob, String name, String address,
			String phone, String creditCardNumber, long ID) {
		super(dob, name, address, phone);
		this.creditCardNumber = creditCardNumber;
		this.ID = ID;
	}
	
	public String getCreditCardNumber()
	{
		return this.creditCardNumber;
	}
	
	public void setCreditCardNumber(String number)
	{
		this.creditCardNumber = number;
	}
	
	public long getID()
	{
		return this.ID;
	}
	
	public void setID(long ID)
	{
		this.ID = ID;
	}
	

}
