package com.smokeyhotel.room;

import com.smokeyhotel.people.guest.Guest;

public class Room {

	private int number;
	private boolean status;
	private double price;
	private Guest[] occupants;
	
	public Room(int number, boolean status, double price, Guest[] occupants)
	{
		this.number = number;
		this.status = status;
		this.price = price;
		this.occupants = occupants;
	}

	public int getNumber() {
		return number;
	}

	public Guest[] getOccupants() {
		return occupants;
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
