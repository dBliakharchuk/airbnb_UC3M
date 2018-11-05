package org.uc3m.ctftw.airbnb.database;

import java.sql.Connection; 

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.uc3m.ctftw.airbnb.model.Apartment;
import org.uc3m.ctftw.airbnb.model.Message;
//import org.uc3m.ctftw.airbnb.model.Trip;
import org.uc3m.ctftw.airbnb.model.User;

public class DataAccess 
{
	static SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.configure("/resources/hibernate.cfg.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
		sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public static void test() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User u");
		System.out.println("mamy " + query + " userow");
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
