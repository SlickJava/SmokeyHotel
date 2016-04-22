package com.smokeyhotel.management.reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class ReservationManager {
	
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public static ArrayList<Guest> guests = new ArrayList<Guest>();
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	public static ArrayList<Room> resRooms = new ArrayList<Room>();
	
	public static void createReservation(Reservation reservation, Database database)
	{
		reservations.add(reservation);
		//TODO uncomment the 3 statements below after db is finished
		//database.insertReservation(reservation);
		//updateRooms(database);
		//addGuests(database);
		System.out.println("Reservation " + reservation.getCode() + " created. Includes " 
				+ reservation.getOccupants().length + " guests and " 
				+ reservation.getRooms().length + " rooms. "
				+ "Master of this reservation is " + reservation.getMaster().getName());
	}
	
	/*
	 * Delete Reservation, returns false if reservation is not in the reservations ArrayList
	 */
	public static boolean deleteReservation(Reservation reservation, Database database)
	{
		Iterator<Reservation> reser = reservations.iterator();
		while(reser.hasNext())
		{
			Reservation res = reser.next();
			if(res.equals(reservation))
			{
				
				for(Room room : rooms)
				{
					if(res.getOccupants() == null)
					{
						continue;
					}
					
					ArrayList<Guest> roomOcc = new ArrayList<Guest>();
					ArrayList<Guest> resOcc = new ArrayList<Guest>();
					Guest[] roomOccupants = room.getOccupants();
					Guest[] resOccupants = res.getOccupants();
					
					for(int i = 0; i < room.getOccupants().length; i++)
					{
						roomOcc.add(roomOccupants[i]);
					}
					
					for(int i = 0; i < res.getOccupants().length; i++)
					{
						resOcc.add(resOccupants[i]);
					}
					
					for(Guest occ : resOcc)
					{
						if(roomOcc.contains(occ))
						{
							room.setOccupants(null);
							room.setVacant(true);
						}
					}
					//TODO Insert remove occupants here
				}
				
				for(Guest guest : guests)
				{
					if(res.getOccupants() == null)
					{
						continue;
					}
					
					Guest[] occupants = res.getOccupants();
					for(int i = 0; i < res.getOccupants().length; i++)
					{
						if(guests.contains(occupants[i]))
						{
							guests.remove(occupants[i]);
						}
					}
				}
				
				reser.remove();
				//database.deleteReservation(res);
				
				
			}else
			{
				return false;
			}
		}
		
		/*
		for(Reservation res : reservations)
		{
			if(res.equals(reservation))
			{
				
				for(Room room : rooms)
				{
					if(res.getOccupants() == null)
					{
						continue;
					}
					
					ArrayList<Guest> roomOcc = new ArrayList<Guest>();
					ArrayList<Guest> resOcc = new ArrayList<Guest>();
					Guest[] roomOccupants = room.getOccupants();
					Guest[] resOccupants = res.getOccupants();
					
					for(int i = 0; i < room.getOccupants().length; i++)
					{
						roomOcc.add(roomOccupants[i]);
					}
					
					for(int i = 0; i < res.getOccupants().length; i++)
					{
						resOcc.add(resOccupants[i]);
					}
					
					for(Guest occ : resOcc)
					{
						if(roomOcc.contains(occ))
						{
							room.setOccupants(null);
							room.setVacant(true);
						}
					}
					//TODO Insert remove occupants here
				}
				
				for(Guest guest : guests)
				{
					if(res.getOccupants() == null)
					{
						continue;
					}
					
					Guest[] occupants = res.getOccupants();
					for(int i = 0; i < res.getOccupants().length; i++)
					{
						if(guests.contains(occupants[i]))
						{
							guests.remove(occupants[i]);
						}
					}
				}
				
				tempRes.remove(res);
				continue;
				//database.deleteReservation(res);
				
				
			}else
			{
				return false;
			}
		}*/
		
		//reservations = database.getReservations();
		//System.out.println(reservations.size());
		return true;
	}
	
	public static void addGuests(Database database)
	{
		for(Room room : rooms)
		{
			guests.addAll(Arrays.asList(room.getOccupants()));
		}
		for(Guest guest : guests)
		{
			database.insertGuest(guest);
		}
	}
	
	public static void updateRooms(Database database)
	{
		for(Room r00m : rooms)
		{
			database.insertRoom(r00m);
		}
	}
	
	public static void addResRooms(Room[] room, Database database)
	{
		resRooms.addAll(Arrays.asList(room));
	}
	
	public static void printGuests()
	{
		for(Guest guest : guests)
		{
			System.out.println("Name: " + guest.getName()
					+ " | Age: " + guest.getDob()
					+ " | Phone: " + guest.getPhone()
					+ " | Credit Card Number: " + guest.getCreditCardNumber()
					+ " | ID: " + guest.getID());
		}

	}
	
	public static ArrayList<Reservation> getReservations()
	{
		return reservations;
	}
	
	public static ArrayList<Guest> getGuests()
	{
		return guests;
	}
	
	public static ArrayList<Room> getRooms()
	{
		return rooms;
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
