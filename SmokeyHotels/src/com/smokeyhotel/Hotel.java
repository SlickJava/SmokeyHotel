package com.smokeyhotel;

import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class Hotel {
	
	public static void main(String args[])
	{
		//TEST
		ReservationManager res = new ReservationManager();
		Guest master = new Guest(20, "Bob Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Guest guest1 = new Guest(20, "Chode Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Guest guest2 = new Guest(20, "Fat Jones", "120 Long Drive", "St Heliers", "0211824071", "1238120381203");
		Room[] room = new Room[1];
		room[0] = new Room(0,true,20.0);
		res.createReservation(new Reservation(master,new Guest[] {guest1, guest2},room));
		res.printGuests();
		
	}

}
