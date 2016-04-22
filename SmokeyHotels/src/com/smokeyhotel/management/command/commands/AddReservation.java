package com.smokeyhotel.management.command.commands;

import java.util.ArrayList;
import java.util.Random;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;
import com.smokeyhotel.utils.ArrayUtils;

public class AddReservation extends Command{

	private Database database;
	private ArrayList<Room> resRooms;
	
	public AddReservation(Database database) {
		super("AddReservation", "addreservation", new String[] {"master","guests"}, 
				"Creates a reservation. Usage: addreservation (master of the reservation: <guestName:guestID>) (guests you want to allocate to rooms <guestName:guestID,guestName:guestID),(and so on)");
		this.database = database;
		resRooms = new ArrayList<Room>(); 
	}

	@Override
	public void onExecute() {
		
		this.allocateRooms();
		this.createReservation();
		//Rest of method is for testing purposes
		/*
		Guest[] test = this.getGuestsFromString(this.inputs[1]);
		for(int i = 0; i < test.length; i++)
		{
			System.out.println(test[i].getDob());
			
		}*/
	}
	
	public Guest getMasterFromString(String mes)
	{
		String[] split = mes.split(":");
		String together = split[0] + split[1];
		Guest guest = null;
		
		for(Guest gst : ReservationManager.guests)
		{
			String guestTogether = gst.getName() + gst.getID();
			if(guestTogether == together || guestTogether.equals(together))
			{
				guest = gst;
			}
		}
		
		return guest;
	}
	
	public Guest[] getGuestsFromString(String message)
	{
		String[] split = message.split(",");
		Guest[] guests = new Guest[split.length];
		
		for(int i = 0; i < split.length; i++)
		{
			String[] colonSplit = split[i].split(":");
			String together = colonSplit[0] + colonSplit[1];
			for(Guest guest : ReservationManager.guests)
			{
				String guestTogether = guest.getName() + guest.getID();
				if(together.equals(guestTogether))
				{
					guests[i] = guest; 
				}
			}
		}
		return guests;
	}
	
	public void createReservation()
	{
		Random random = new Random();
		long LOWER_RANGE = 0;
		long UPPER_RANGE = 1000000;
		long generateID = LOWER_RANGE + 
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		
		//CHECK IF CODE IS IN USE
		for(Reservation res : ReservationManager.reservations)
		{
			 generateID = LOWER_RANGE + 
                     (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
			 
			if(res.getCode() == generateID)
			{
				 generateID = LOWER_RANGE + 
				                           (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
			}
		}
		Room[] rooms = (Room[]) resRooms.toArray(new Room[resRooms.size()]);
		Reservation reservation = new Reservation(generateID, this.getMasterFromString(this.inputs[0]), rooms);
		ReservationManager.createReservation(reservation, database);
	
	}
	
	public void allocateRooms() {
		
		Guest[] guests = this.getGuestsFromString(this.inputs[1]);
		int backIndex = guests.length - 1;

		for(Room room: ReservationManager.rooms)
		{
			if(room.getOccupants() == null)
			{
				if(room.isVacant())
				{
					if(backIndex != -1)
					{
						Guest[] occupants = new Guest[room.getMaxNumberOfOccupants()];
						
						for(int i = 0; i < occupants.length; i++)
						{
							if(backIndex < 0)
								continue;
						
							occupants[i] = guests[backIndex];
							backIndex--;
						}
						
						for(int i = 0; i < occupants.length; i++)
						{
							if(occupants[i] == null || occupants[i].equals(null)) {
								occupants = ArrayUtils.removeNullGuest(occupants);
								continue;
							}
						}
						
						room.setOccupants(occupants);
						room.setVacant(false);
						resRooms.add(room);
						
						for(int i = 0; i < occupants.length; i++)
						{
							System.out.println("Guest: " + occupants[i].getName() 
									+ " has been allocated to room " + room.getNumber());
						}
						
					}
				}	
				
			}
		}

	}

}
