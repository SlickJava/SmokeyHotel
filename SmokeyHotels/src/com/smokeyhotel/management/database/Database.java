package com.smokeyhotel.management.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.awesome.db.AwesomeDatabase;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.smokeyhotel.management.reservation.Reservation;
import com.smokeyhotel.people.guest.Guest;
import com.smokeyhotel.room.Room;

/**
 * @author InsaneAboutTNT
 * This class houses the database
 * and provides methods for adding and
 * deleting data in the hotel database.
 */
public class Database {
	private AwesomeDatabase awesomeDatabase;
	/**
	 * Initiate a data source and
	 * make a new AwesomeDatabase to use
	 */
	public Database() {
		try {
			FileReader reader = new FileReader("config.properties");
			Properties props = new Properties();
			props.load(reader);
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser(props.getProperty("user"));
			dataSource.setPassword(props.getProperty("password"));
			dataSource.setURL(props.getProperty("url"));
			awesomeDatabase = new AwesomeDatabase(dataSource);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * DO NOT USE YET!!! (unless you want to ruin the database
	 * and your own life.)
	 * (TODO complete this stuff)
	 * */
	/**
	 * Add a reservation
	 * @param reservation
	 */
	public void insertReservation(Reservation reservation) {
		// TODO do later
		// Maybe do: if exists (insert into guest values( ... ))
		// RESERVATION table.
		awesomeDatabase.createQuery("insert into reservation"
				+ "(reservation_code, master_guest_id) values "
				+ "(?,"
				+ "select id from guest where name=?)")
			.params(reservation.getCode(), reservation.getMaster().getName());
		// Insert into JUNCTION TABLE
		// Note: maybe change Reservation.id to Reservation.reservationCode
		awesomeDatabase.createQuery("insert into guest_reservation"
				+ "(reservation_id, guest_id) values"
				+ "((select id from reservation where reservation_code=?,"
				+ "(select id from guest where name=?))")
			// Lambdas FTW!!
			.setStatement(statement -> {
				for (Guest guest: reservation.getOccupants()) {
					// Change to reservationCode?
					statement.setLong(1, reservation.getCode());
					statement.setString(2, guest.getName());
				}
			});
	}
	
	/**
	 * Returns awesomeDatabase
	 */
	public AwesomeDatabase getAwesomeDatabase() {
		return this.awesomeDatabase;
	}
	/**
	 * Add a guest
	 * @param guest
	 */
	public void insertGuest(Guest guest) {
		// TODO
		awesomeDatabase.createQuery("insert into guest"
				+ " (dob, name, address, phone, creditCardNumber,"
				+ " expiryDate, creditCardName, creditCardSecurity)"
				+ " values (?, ?)")
			// could've use params(), but imo this looks better
		    .setStatement(statement -> {
		    	statement.setString(1, guest.getName());
		    });
	}
	/**
	 * Add a room
	 * @param room
	 */
	public void insertRoom(Room room) {
		// TODO
		awesomeDatabase.createQuery("insert into room (number) values (?)")
			.params(room.getNumber());
	}
	public ArrayList<Guest> getAllGuests() {
		// TODO
		return null;
	}
	public Reservation getReservation() {
		return null;
	}
	public void deleteReservation(Reservation reservation) {
		
	}
}
