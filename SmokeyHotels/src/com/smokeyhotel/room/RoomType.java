package com.smokeyhotel.room;

public class RoomType {
	
	private String roomTypeName;
	private int amountOfOccupants;
	private double price;
	
	public RoomType(String roomTypeName, int amountOfOccupants, double price)
	{
		this.roomTypeName = roomTypeName;
		this.amountOfOccupants = amountOfOccupants;
		this.price = price;
	}

	public int getAmountOfOccupants() {
		return amountOfOccupants;
	}

	public void setAmountOfOccupants(int amountOfOccupants) {
		this.amountOfOccupants = amountOfOccupants;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
