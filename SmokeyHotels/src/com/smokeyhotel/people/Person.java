package com.smokeyhotel.people;

import java.time.LocalDate;

/**
 * Person Base Class.
 * @author SlickJava & InsaneAboutTNT
 */

public class Person {
	
	private LocalDate dob;
	private String name;
	private String address;
	private long phone;
	
	public Person(LocalDate dob, String name, String address,long phone)
	{
		this.dob = dob;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	

}
