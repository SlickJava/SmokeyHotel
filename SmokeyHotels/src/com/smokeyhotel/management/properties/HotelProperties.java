package com.smokeyhotel.management.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.smokeyhotel.Hotel;

public class HotelProperties {
	
	private FileReader hotelProp;
	private Properties props = new Properties();
	
	public HotelProperties()
	{
		try {
			hotelProp = new FileReader("hotel.properties");
			props.load(hotelProp);
			Hotel.amountOfRooms = Integer.parseInt(props.getProperty("roomamount"));
			Hotel.hotelName = props.getProperty("hotelname");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
