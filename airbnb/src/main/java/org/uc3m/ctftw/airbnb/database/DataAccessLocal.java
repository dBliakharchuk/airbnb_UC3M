package org.uc3m.ctftw.airbnb.database;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.uc3m.ctftw.airbnb.model.Apartment;
import org.uc3m.ctftw.airbnb.model.Localization;
import org.uc3m.ctftw.airbnb.model.Message;
import org.uc3m.ctftw.airbnb.model.Trip;
import org.uc3m.ctftw.airbnb.model.User;

public class DataAccessLocal
{
	private static ArrayList<Apartment> apartments = new ArrayList<Apartment>();
	private static ArrayList<Message> messages = new ArrayList<Message>();
	private static ArrayList<Trip> trips = new ArrayList<Trip>();
	private static ArrayList<User> users = new ArrayList<User>();

	public static void initialize()
	
	{	initializeUsers();
		initializeApartments();
		initializeMessages();
		initializeTrips();

	}
	
	

	public static User getUserByEmail(String email)
	{
		for(int i=0; i < users.size(); i++)
		{
			if(email.equals(users.get(i).getEmail()) )
				return users.get(i);
		}
		return null;
	}

	public static User getUserByNameAndSurname(String name, String surname)
	{
		for(int i=0; i < users.size(); i++)
		{
			if(name.equals(users.get(i).getName()) && surname.equals(users.get(i).getSurname()))
				return users.get(i);
		}
		return null;
	}

	public static List<Apartment> getAllApartments()
	{
		return apartments;
	}

	public static Apartment getApartmentByName(String name)
	{
		for(int i=0; i < apartments.size(); i++)
		{
			if(name.equals(apartments.get(i).getName()))
				return apartments.get(i);
		}
		return null;
	}

	public static List<Message> getUserMessages(User user)
	{
		return messages;
	}

	public static List<Trip> getUserTrips(User user)
	{
		return trips;
	}

	private static void initializeUsers()
	{
		User newUser = new User("fakeMail@gmail.com", "Jan", "Kowal", "haslo12");
		users.add(newUser);
		
		newUser = new User("andrzejduda@gmail.com", "Andrzej", "Duda", "dudaczynicuda");
		users.add(newUser);
		
	}
	
	private static void initializeApartments()
	{
		User user = new User("fakeMail@gmail.com", "Jan", "Kowal", "haslo12");
		Localization localization = new Localization("Polan", "Warsaw", "Chmielna", 4, 4);
		List<java.sql.Date> bookedDays = new ArrayList<java.sql.Date>();
		BigDecimal price = new BigDecimal(50);
		Apartment newApartment = new Apartment("Apartment in Warsaw", "super cooll single room studio", user, localization, price, "single room studio", 1, 1, bookedDays);
		apartments.add(newApartment);
	}
	
	
	private static void initializeMessages()
	{
		Date date = new Date(115, 11, 1);
		Message newMessage = new Message(false, "Does house have parking place?", date);
		
		messages.add(newMessage);
		
		date = new Date(115, 11, 11);
		newMessage = new Message(false, "Is it a quiete neighborhood?", date);
		
		messages.add(newMessage);
		
		date = new Date(113, 11, 11);
		newMessage = new Message(true, "I like footbal.", date);
		
		messages.add(newMessage);
		
		date = new Date(114, 5, 11);
		newMessage = new Message(true, "Bulid the wall!.", date);
		
		messages.add(newMessage);
	}

	private static void initializeTrips()
	{
		Date dateIn = new Date(115, 11, 1);
		Date dateOut = new Date(115, 11, 6);
		URL url;
		try
		{
			url = new URL(
					"https://www.esmadrid.com/sites/default/files/styles/content_type_full/public/edfitorial/Madrid_undia_1397223554.735.jpg?itok=4ziKw0gD");
			Trip newTrip = new Trip("Madrit", "super apartment", dateIn, dateOut, url);
			trips.add(newTrip);
		} catch (MalformedURLException e)
		{

			e.printStackTrace();
		}
		
		
		dateIn = new Date(116, 1, 11);
		dateOut = new Date(116, 1, 16);
		
		try
		{
			url = new URL(
					"https://www.esmadrid.com/sites/default/files/styles/content_type_full/public/edfitorial/Madrid_undia_1397223554.735.jpg?itok=4ziKw0gD");
			Trip newTrip = new Trip("Apartment in Warsaw", "single room studio", dateIn, dateOut, url);
			trips.add(newTrip);
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		dateIn = new Date(116, 11, 1);
		dateOut = new Date(116, 11, 18);
		
		try
		{
			url = new URL(
					"https://www.esmadrid.com/sites/default/files/styles/content_type_full/public/edfitorial/Madrid_undia_1397223554.735.jpg?itok=4ziKw0gD");
			Trip newTrip = new Trip("Apartment near Gran Via", "Entire apartment, one bed", dateIn, dateOut, url);
			trips.add(newTrip);
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
