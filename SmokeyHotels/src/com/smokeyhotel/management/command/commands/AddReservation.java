package com.smokeyhotel.management.command.commands;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

public class AddReservation extends Command{

	private Database database;
	
	public AddReservation(Database database) {
		super("AddReservation", "addreservation", new String[] {"master","guests"}, 
				"Creates a reservation. Usage: addreservation <master> <guest:guestID:roomID,guest:guestID:roomID,(and so on)");
		this.database = database;
	}

	@Override
	public void onExecute() {
		
		for(int i = 0; i < this.inputs.length; i++)
		{
			System.out.println(this.inputs[i]);

		}
		//Rest of method is for testing purposes
		Guest[] test = this.getGuestsFromString(this.inputs[1]);
		for(int i = 0; i < test.length; i++)
		{
			System.out.println(test[i].getDob());
			
		}
		Room[] test2 = this.getRoomsFromString(this.inputs[1]);
		for(int i = 0; i < test2.length; i++)
		{
			System.out.println(test2[i].getPrice());
		}
	}
	
	public Room[] getRoomsFromString(String mes)
	{
		String[] split = mes.split(",");
		Room[] rooms = new Room[split.length];
		for(int i = 0; i < split.length; i++)
		{
			String[] colonSplit = split[i].split(":");
			String roomID = colonSplit[2];
			for(Room room : ReservationManager.rooms)
			{
				
				if(roomID.equals(room.getID()))
				{
					rooms[i] = room;
				}
			}
		}
		return rooms;
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
	
	public void allocateRooms() {

	}

}
