package database;

import java.sql.Connection;  

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Apartment;
import model.Reservation;
import model.Message;
import model.User;

public class DataAccess 
{	
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("airbnb");
	
	public static List<User> test() {
		System.out.println("TEST INCOMING");
		List<User> results;
		EntityManager manager = managerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("User.findAll", User.class);
			results = query.getResultList();
		} finally {
			manager.close();
		}
		System.out.println("TEST");
		System.out.println(results);
		return results;
	}
	
	
	public static User getUserByEmail(String email) {
		return null;
	}
	
	public static User getUserByNameAndSurname(String name, String surname) {
		return null;
	}
	
	public static List<Apartment> getAllApartments() {
		return null;
	}
	
	public static Apartment getApartmentByName(String name) {
		return null;
	}
	
	public static List<Message> getUserMessages(User user) {
		return null;
	}
	
	/*public static List<Trip> getUserTrips(User user) {
		return null;
	}*/
	

}
