package com.smokeyhotel;

import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Hotel {
	
	public static void main(String args[])
	{
		//TEST
		//INIT ReservationManager
		ReservationManager res = new ReservationManager();
		
		//CREATE GUEST OBJECTS
		Guest master = new Guest(20, "Bob Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Guest guest1 = new Guest(20, "Chode Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Guest guest2 = new Guest(20, "Fat Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		
		//CREATE GUEST ARRAY
		Guest[] occupants = new Guest[] {guest1,guest2};
		
		//CREATE ROOMS ARRAY
		Room[] rooms = new Room[1];
		rooms[0] = new Room(0,true,20.0,occupants);
		
		//CREATE RESERVATION
		res.createReservation(new Reservation(master,occupants,rooms));
		
		//PRINT GUESTS
		res.printGuests();
		
	}

}
