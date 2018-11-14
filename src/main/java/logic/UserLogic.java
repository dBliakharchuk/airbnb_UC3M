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
	
	public static boolean isUserRegistered(User user) {
		return user != null && DataAccess.getUserByEmail(user.getEmail()) != null;
	}
	
	public static boolean isUserValid(User user) {
		//TODO
		//password strength check etc
		return true;
	}

}
