package logic;

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
		
		DataAccess.updateUser(user);
		return true;
	}
	
	public static boolean registerUser(User user) {
		if (user == null || !isUserValid(user) || isUserRegistered(user)) {
			return false;
		}
		
		DataAccess.createUser(user);
		return true;
	}
	
	public static boolean deleteUser(User user) {
		if (user == null || !isUserRegistered(user)) {
			return false;
		}
		
		for (Message m : user.getMessagesSent()) {
			DataAccess.removeMessage(m);
		}
		for (Message m : user.getMessagesReceived()) {
			DataAccess.removeMessage(m);
		}
		user.setMessagesReceived(null);
		user.setMessagesSent(null);
		
		for (Apartment a : user.getApartments()) {
			ApartmentLogic.removeApartment(a);
		}
		
		user.setApartments(null);
		
		for (Reservation r : user.getReservations()) {
			TripLogic.removeReservation(r);
		}
		
		user.setReservations(null);
		
		return DataAccess.removeUser(user);
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
