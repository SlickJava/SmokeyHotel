package com.smokeyhotel.management.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.awesome.db.AwesomeDatabase;
import com.awesome.db.ListResultMapper;
import com.awesome.db.ResultMapper;
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
	private ListResultMapper<Guest> guestMapper;
	/**
	 * Initiate a data source and
	 * make a new AwesomeDatabase to use
	 */
	public Database() {
		 guestMapper = new ListResultMapper<Guest>() {
			public Guest mapRow(ResultSet resultSet) throws SQLException {
				return new Guest(resultSet.getDate("dob").toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate(),
						resultSet.getString("name"),
						resultSet.getString("address"),
						resultSet.getLong("phoneNumber"),
						resultSet.getLong("creditCardNumber"),
						resultSet.getDate("expiryDate").toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate(),
						resultSet.getString("creditCardName"),
						resultSet.getInt("creditCardSecurityNumber"),
						resultSet.getLong("userUniqueId"));
			}
		};
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
			.params(reservation.getCode(), reservation.getMaster().getName())
			.executeUpdate();
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
					statement.addBatch();
				}
			}).executeBatch();
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
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)")
			// could've use params(), but imo this looks better
			// Lambdas FOR THE WIN
		    .setStatement(statement -> {
		    	statement.setDate(1, Date.valueOf(guest.getDob()));
		    	statement.setString(2, guest.getName());
		    	statement.setString(3, guest.getAddress());
		    	statement.setString(4, String.valueOf(guest.getPhone()));
		    	statement.setString(5, String.valueOf(guest.getPhone()));
		    	statement.setDate(6, Date.valueOf(guest.getExpiryDate()));
		    	statement.setString(7, guest.getCreditCardName());
		    	statement.setInt(8, guest.getCreditCardSecurity());
		    	// contunie!!!!typo :)
		    });
	}
	/**
	 * Add a room
	 * @param room
	 */
	public void insertRoom(Room room) {
		// TODO
		awesomeDatabase.createQuery("insert into room (number) values (?)")
			.params(room.getNumber()).executeUpdate();
	}
	public ArrayList<Guest> getAllGuests() {
		// TODO
		// Get ArrayList from the List
		ArrayList<Guest> guests = new ArrayList<>(awesomeDatabase.createQuery("select * from guest")
				.executeQuery(guestMapper));
		return guests;
	}
	public ArrayList<Room> getAllRooms() {
		return null;
	}
	public Reservation getAllReservations() {
		// TODO
		// IMPORTANT
		awesomeDatabase.createQuery("select * from reservation"
				+ "join room on (room.current_reservation_id = reservation.id)"
				+ "join guest on ()");
//			.executeQuery(new ResultMapper<Reservation>() {
//				
//			});
		return null;
	}
	public void deleteReservation(Reservation reservation) {
		
		// TOOOODO TODO
		// Del reservation, and del these guests.
		awesomeDatabase.createQuery("delete from reservation where reservationCode=?")
			.params(reservation.getCode()).executeBatch();
		awesomeDatabase.createQuery("delete from guest where guestUniqueId=?")
			.setStatement(statement -> {
				for (Guest guest: reservation.getOccupants()) {
					statement.setLong(1, guest.getID());
					statement.addBatch();
				}
			}).executeUpdate();
		//awesomeDa
	}
	//public void 
}
