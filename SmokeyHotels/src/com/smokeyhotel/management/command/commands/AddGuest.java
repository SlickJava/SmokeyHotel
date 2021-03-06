package com.smokeyhotel.management.command.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.ReservationManager;
import com.smokeyhotel.people.guest.Guest;

public class AddGuest extends Command{
	
	private Database database;

	public AddGuest(Database database) {
		super("AddGuest", "addguest", new String[] {
				"Name", "DateOfBirth", "Address",
				"Phone", "creditCardNumber", "expiryDate",
				 "creditCardName", "creditCardSecurity"}, "Adds a guest.");
		this.database = database;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onExecute() {

		Random random = new Random();
		long LOWER_RANGE = 0;
		long UPPER_RANGE = 1000000;
		long ID = LOWER_RANGE + 
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		
		for(Guest goost : ReservationManager.guests)
		{
			 ID = LOWER_RANGE + 
                     (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
			 
			if(goost.getID() == ID)
			{
				 ID = LOWER_RANGE + 
		                           (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
			}
		}
		
		Guest guest = new Guest(this.getDateOfBirth(), this.getName(), this.getAddress(), 
				this.getPhone(), this.getCreditCardNumber(), this.getCreditCardExipryDate(), 
				this.getCreditCardName(), this.getCreditCardSecurity(), ID);
		
		ReservationManager.addGuest(guest, database);
		
		System.out.println("Added guest " + guest.getName() + " with the ID of " + guest.getID() + ".");
		//System.out.println(ReservationManager.guests.size() + " size of guests arraylist (testing purposes)");
		
	}
	
	public LocalDate getDateOfBirth()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		LocalDate dt = LocalDate.parse(this.inputs[1], dtf);
		
		return dt;
	}

	public String getName()
	{
		return this.inputs[0];
	}
	
	public String getAddress()
	{
		return this.inputs[2];
	}
	
	public String getPhone()
	{
		return this.inputs[3];
	}
	
	public String getCreditCardNumber()
	{
		return this.inputs[4];
	}
	
	public LocalDate getCreditCardExipryDate()
	{
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
	    LocalDate dt = LocalDate.parse(this.inputs[5], dtf);
		
		return dt;
	}
	
	public String getCreditCardName()
	{
		return this.inputs[6];
	}
	
	public int getCreditCardSecurity()
	{
		return Integer.parseInt(this.inputs[7]);
	}
	
	
}
