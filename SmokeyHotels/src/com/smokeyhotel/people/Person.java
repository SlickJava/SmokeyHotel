package com.smokeyhotel.people;

/**
 * Person Base Class.
 * @author SlickJava & InsaneAboutTNT
 */

public class Person {
	
	private int age;
	private String name;
	private String address;
	private String suburb;
	private String phone;
	
	public Person(int age, String name, String address, String suburb, String phone)
	{
		this.age = age;
		this.name = name;
		this.address = address;
		this.suburb = suburb;
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
