package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class ListRooms extends Command{

	public ListRooms() {
		super("ListRooms", "listrooms", new String[] {}, "Lists all rooms and their status.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {
		
		for(Room room : ReservationManager.rooms)
		{
			System.out.println("------------------------");
			System.out.println("Room Number: " + room.getNumber());
			System.out.println("Type: " + room.getRoomType().getRoomTypeName());
			System.out.println("Price: " + room.getPrice());
			System.out.println("Vacant: " + room.isVacant());
			
			if(room.getOccupants() != null)
				System.out.println("Occupants: " + room.getOccupants().length + " occupants.");	
			else
				System.out.println("Occupants: " + "0 occupants.");
			
			if(room.getOccupants() != null && room.getOccupants().length > 0) {
				Guest[] occ = room.getOccupants();
				for(int i = 0; i < occ.length; i++)
				{
					System.out.println("Occupant Details - ");
					System.out.println("         -" + occ[i].getName() + " | " + occ[i].getID());
				}
			}
			
			
		}
		
	}

}
