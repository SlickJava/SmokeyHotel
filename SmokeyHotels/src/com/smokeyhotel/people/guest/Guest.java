package com.smokeyhotel.people.guest;

import java.time.LocalDate;

import com.smokeyhotel.people.Person;

/**
 * Guest Object Class.
 * @author SlickJava & InsaneAboutTNT
 */

public class Guest extends Person{
	
	private long creditCardNumber;
	private LocalDate expiryDate;
	private String creditCardName;
	private int creditCardSecurity;
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
			long phone, long creditCardNumber, LocalDate expiryDate, String creditCardName, int creditCardSecurity, long ID) {
		super(dob, name, address, phone);
		this.creditCardNumber = creditCardNumber;
		this.expiryDate = expiryDate;
		this.creditCardName = creditCardName;
		this.creditCardSecurity = creditCardSecurity;
		this.ID = ID;
	}
	
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	public int getCreditCardSecurity() {
		return creditCardSecurity;
	}

	public void setCreditCardSecurity(int creditCardSecurity) {
		this.creditCardSecurity = creditCardSecurity;
	}

	public long getCreditCardNumber()
	{
		return this.creditCardNumber;
	}
	
	public void setCreditCardNumber(long number)
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
