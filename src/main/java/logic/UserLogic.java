package logic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import database.DataAccess;
import model.Apartment;
import model.Message;
import model.Reservation;
import model.User;

public class UserLogic {
	
	public static boolean modifyUser(User user) {
		if (user == null || !isUserValid(user) || !isUserRegistered(user)) {
			return false;
		}
		
		return DataAccess.updateUser(user);
	}
	
	public static boolean registerUser(User user) {
		if (user == null || !isUserValid(user) || isUserRegistered(user)) {
			return false;
		}
		
		return DataAccess.createUser(user);
	}
	
	public static boolean deleteUser(User user) {
		if (user == null || !isUserRegistered(user)) {
			return false;
		}
		
		return DataAccess.removeUser(user);
	}
	
	public static boolean changeUserName(String email, String name) {
		User toChange = DataAccess.getUserByEmail(email);
		toChange.setName(name);
		return DataAccess.updateUser(toChange);
	}
	
	public static boolean changeUserSurname(String email, String surname) {
		User toChange = DataAccess.getUserByEmail(email);
		toChange.setSurname(surname);
		return DataAccess.updateUser(toChange);
	}
	
	public static boolean changeUserPassword(String email, String password) {
		User toChange = DataAccess.getUserByEmail(email);
		toChange.setPassword(password);
		return DataAccess.updateUser(toChange);
	}
	
	public static boolean changeUserPhone(String email, String phone) {
		User toChange = DataAccess.getUserByEmail(email);
		toChange.setPhone(phone);
		return DataAccess.updateUser(toChange);
	}
	
	public static Set<Apartment> getRentedApartmentsByUser(User user) {
		if (user == null) {
			return null;
		}
		
		List<Reservation> reservations = DataAccess.getAllReservations();
		Set<Apartment> apartmentsRented = new HashSet<>();
		for (Reservation r : reservations) {
			if (r.getUser().equals(user)) {
				apartmentsRented.add(r.getApartment());
			}
		}
		
		return apartmentsRented;
	}
	
	public static boolean isUserRegistered(User user) {
		return user != null && DataAccess.getUserByEmail(user.getEmail()) != null;
	}
	
	public static boolean isUserValid(User user) {
		//TODO
		//password strength check etc
		return true;
	}

}
