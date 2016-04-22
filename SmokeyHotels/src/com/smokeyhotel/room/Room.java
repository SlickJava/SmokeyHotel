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
	private long ID;
	private int maxNumberOfOccupants;
	
	/**
	 * Constructor:
	 * Parameter number is the roo
	 * @param number - the room number
	 * @param vacant - vacancy of the room
	 * @param roomState - state of the room, eg. DAMAGED, BEING_CLEANED, MADE
	 * @param price - price of the room
	 * @param occupants - array of Guest[] objects occupying the room
	 */

	public Room(int roomNumber, int maxNumberOfOccupants,boolean vacant,  double price, Guest[] occupants, long ID)
	{
		this.number = roomNumber;
		this.vacant = vacant;
		this.price = price;
		this.occupants = occupants;
		this.ID = ID;
		this.maxNumberOfOccupants = maxNumberOfOccupants;
	}
	
	public int getMaxNumberOfOccupants() {
		return maxNumberOfOccupants;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
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
