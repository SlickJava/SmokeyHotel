package com.smokeyhotel.room;

import com.smokeyhotel.people.Person;

public class Room {

	private int number;
	private boolean status;
	private double price;
	
	public Room(int number, boolean status, double price)
	{
		this.number = number;
		this.status = status;
		this.price = price;
	}

	public int getNumber() {
		return number;
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
