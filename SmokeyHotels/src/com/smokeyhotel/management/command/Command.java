package com.smokeyhotel.management.command;

import com.smokeyhotel.management.database.Database;

public abstract class Command {
	
	private String message;
	private String commandName;
	private String[] parameters;
	private String[] inputs;
	public Database database;
	
	public Command(String commandName, String message, String[] parameters, Database database)
	{
		this.message = message;
		this.commandName = commandName;
		this.parameters = parameters;
	}

	public String[] getParameters()
	{
		return this.parameters;
	}
	
	public void setInputs(String[] inputs)
	{
		this.inputs = inputs;
	}
	public String getMessage()
	{
		return this.message;
	}
	
	public String getCommandName()
	{
		return this.commandName;
	}
	
	public abstract void onExecute();
	
}
