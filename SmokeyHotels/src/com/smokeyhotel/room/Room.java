package com.smokeyhotel.room;

import com.smokeyhotel.people.guest.Guest;

/**
 * Room Object base class.
 * @author SlickJava & InsaneAboutTNT
 */

public class Room {

	private int number;
	private boolean vacant;
	private double price;
	private Guest[] occupants;
	private int maxNumberOfOccupants;
	

	/**
	 * Constructor
	 * @param roomNumber
	 * @param vacant
	 * @param price
	 * @param occupants
	 * @param maxNumberOfOccupants
	 */
	public Room(int roomNumber, int maxNumberOfOccupants, boolean vacant, double price, Guest[] occupants)
	{
		this.number = roomNumber;
		this.vacant = vacant;
		this.price = price;
		this.occupants = occupants;
		this.maxNumberOfOccupants = maxNumberOfOccupants;
	}
	
	public int getMaxNumberOfOccupants() {
		return maxNumberOfOccupants;
	}

	public int getNumber() {
		return number;
	}
	
	public Guest[] getOccupants() {
		return occupants;
	}
	
	public void setOccupants(Guest[] guest) {
		this.occupants = guest;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
