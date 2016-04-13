package com.smokeyhotel.room;

import com.smokeyhotel.people.Person;

public class Room {

	private int number;
	private boolean status;
	private double price;
	private Person person;
	
	public Room(int number, boolean status, double price, Person person)
	{
		this.number = number;
		this.status = status;
		this.price = price;
		this.person = person;
	}

	public int getNumber() {
		return number;
	}

	public Person getPerson() {
		return this.person;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
