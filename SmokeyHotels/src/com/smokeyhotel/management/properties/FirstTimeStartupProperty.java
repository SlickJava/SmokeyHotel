package com.smokeyhotel.management.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.smokeyhotel.Hotel;

public class FirstTimeStartupProperty {
	
	private File startupFile;
	private FileWriter startupWriter;
	private FileReader startupReader;
	private Properties props = new Properties();
	
	public FirstTimeStartupProperty()
	{
		try {
			startupFile = new File("startup.properties");
			
			startupReader = new FileReader("startup.properties");
			props.load(startupReader);
			Hotel.firstTimeStartup = Boolean.parseBoolean(props.getProperty("firsttimestartup"));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
