package com.smokeyhotel.management.command;

import com.smokeyhotel.management.database.Database;

public abstract class Command {
	
	private String message;
	private String commandName;
	private String[] parameters;
	protected String[] inputs;
	private String description;
	
	public Command(String commandName, String message, String[] parameters, String description)
	{
		this.message = message;
		this.commandName = commandName;
		this.parameters = parameters;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getParameters()
	{
		return this.parameters;
	}
	
	public void setInputs(String[] inputs)
	{
		this.inputs = inputs;
	}
	
	public String[] getInputs()
	{
		return this.inputs;
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
