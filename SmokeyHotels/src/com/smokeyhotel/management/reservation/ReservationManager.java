package com.smokeyhotel.management.reservation;

import com.smokeyhotel.room.Room;

public class ReservationManager {
	
	//private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	//private ArrayList<Room> rooms = new ArrayList<Room>();
	
	public boolean doesReservationHaveRoom(Reservation reservation, Room room)
	{

		if(reservation.getRooms() != 1)
		{
			for(int i = 0; i <reservation.getRooms(); i++)
			{
				if(reservation.getRoomNumber(i) == room.getNumber())
				{
					return true;
				}
			}
		}else
		{
			if(reservation.getRoomNumber(0) == room.getNumber())
			{
				return true;
			}
		}
		//really didn't need that if statement lol
		
		return false;
	}
	

}
