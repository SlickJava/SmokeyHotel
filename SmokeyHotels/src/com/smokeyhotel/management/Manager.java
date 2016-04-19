package com.smokeyhotel.management;

import java.util.ArrayList;
import java.util.Scanner;

import com.smokeyhotel.management.command.Command;
import com.smokeyhotel.management.command.commands.AddReservation;
import com.smokeyhotel.management.database.Database;
import com.smokeyhotel.management.reservation.ReservationManager;

public class Manager {
	
	private ArrayList<Command> commands = new ArrayList<Command>();
	private ReservationManager reservationManager;
	private Database database;
	private Scanner scanner;
	
	public Manager()
	{
		scanner = new Scanner(System.in);
		database = new Database();
		reservationManager = new ReservationManager();
		this.addCommands();
	}
	
	public void addCommands()
	{
		commands.add(new AddReservation(database));
	}
	
	public String readMessage()
	{
		String message = scanner.nextLine();
		return message;
	}
	
	/**
	 * Initiates the command. Runs through all commands, finds the matching message, 
	 * splits the string to find the parameters, then executes the command accordingly.
	 * 
	 * @param message
	 **/
	public void initiateCommand(String message)
	{
		String[] split = message.split(" ");		
		for(Command command : commands)
		{
			if(command.getMessage().equals(split[0]))
			{
				String[] inputs = new String[command.getParameters().length];
				for(int i = 0; i < command.getParameters().length; i++)
				{
					inputs[i] = split[i+1];
				}
				command.setInputs(inputs);
				command.onExecute();
				
			}else
			{
				System.out.println("Unkown message: " + message);
			}
		}
	}
	
	/**
	 * Initiates command listener. Listeners from commands.
	 **/
	public void initiateCommandListener()
	{
	    while (true) {
	    	String input = this.readMessage();
	        this.initiateCommand(input);
	        if(input.equals("exit")){
	            break;
	        }
	    }
	}
	
}
