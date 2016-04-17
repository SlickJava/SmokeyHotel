package com.smokeyhotel.management.reservation;

import java.util.ArrayList;

import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class ReservationManager {
	
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public ArrayList<Guest> guests = new ArrayList<Guest>();
	public ArrayList<Room> rooms = new ArrayList<Room>();
	
	public void createReservation(Reservation reservation)
	{
		this.reservations.add(reservation);
		this.addGuests(reservation.getOccupants());
		this.addRooms(reservation.getRooms());
	}
	
	public void addGuests(Guest[] guest)
	{
		for(int i = 0; i <guest.length; i++)
		{
			this.guests.add(guest[i]);
		}
		
	}
	
	public void addRooms(Room[] room)
	{
		for(int i = 0; i <room.length; i++)
		{
			this.rooms.add(room[i]);
		}
	}


}
