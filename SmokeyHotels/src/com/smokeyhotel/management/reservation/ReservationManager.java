package com.smokeyhotel.management.reservation;

import java.util.ArrayList;
import java.util.Arrays;

import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class ReservationManager {
	
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public static ArrayList<Guest> guests = new ArrayList<Guest>();
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public void createReservation(Reservation reservation, Database database)
	{
		this.reservations.add(reservation);
		database.insertReservation(reservation);
		this.addRooms(reservation.getRooms(), database);
		this.addGuests(database);
	}
	
	/*
	 * Delete Reservation, returns false if reservation is not in the reservations ArrayList
	 */
	public boolean deleteReservation(Reservation reservation)
	{
		for(Reservation res : reservations)
		{
			if(res.equals(reservation))
			{
				reservations.remove(reservation);
			}else
			{
				return false;
			}
		}
		return true;
	}
	
	public void addGuests(Database database)
	{
		for(Room room : this.rooms)
		{
			this.guests.addAll(Arrays.asList(room.getOccupants()));
		}
		for(Guest guest : this.guests)
		{
			database.insertGuest(guest);
		}
	}
	
	public void addRooms(Room[] room, Database database)
	{
		rooms.addAll(Arrays.asList(room));
		for(Room r00m : this.rooms)
		{
			database.insertRoom(r00m);
		}
	}
	
	public void printGuests()
	{
		for(Guest guest : this.guests)
		{
			System.out.println("Name: " + guest.getName()
					+ " | Age: " + guest.getDob()
					+ " | Phone: " + guest.getPhone()
					+ " | Credit Card Number: " + guest.getCreditCardNumber());
		}

	}
	
	public ArrayList<Reservation> getReservations()
	{
		return this.reservations;
	}
	
	public ArrayList<Guest> getGuests()
	{
		return this.guests;
	}
	
	public ArrayList<Room> getRooms()
	{
		return this.rooms;
	}

    public static Guest getGuestbyName(final String name)
    {
        for (final Guest guest : guests)
        {
            if (guest.getName() == name || guest.getName().equalsIgnoreCase(name))
            {
                return guest;
            }
        }

        return null;
    }

}
