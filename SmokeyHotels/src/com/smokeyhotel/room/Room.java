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
	private RoomState roomState;
	private Guest[] occupants;
	
	/**
	 * Constructor:
	 * Parameter number is the roo
	 * @param number - the room number
	 * @param vacant - vacancy of the room
	 * @param roomState - state of the room, eg. DAMAGED, BEING_CLEANED, MADE
	 * @param price - price of the room
	 * @param occupants - array of Guest[] objects occupying the room
	 */

	public Room(int number, boolean vacant, RoomState roomState, double price, Guest[] occupants)
	{
		this.number = number;
		this.vacant = vacant;
		this.price = price;
		this.occupants = occupants;
		this.roomState = roomState;
	}

	public int getNumber() {
		return number;
	}
	
	public void setRoomState(RoomState state)
	{
		this.roomState = state;
	}

	public RoomState getRoomState()
	{
		return roomState;
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
