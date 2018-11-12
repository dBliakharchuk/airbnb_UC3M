package logic;

import database.DataAccess;
import model.User;

public class UserLogic {
	
	public static void createOrUpdateUser(User user) {
		if (!isUserValid(user)) {
			return;
		}
		
		if (!isUserRegistered(user)) {
			DataAccess.createUser(user);
		} else {
			DataAccess.updateUser(user);
		}
	}
	
	public static void createUser(User user) {
		if (!isUserValid(user)) {
			return;
		}
		
		DataAccess.createUser(user);
	}
	
	public static boolean isUserRegistered(User user) {
		return DataAccess.getUserByEmail(user.getEmail()) != null;
	}
	
	public static boolean isUserValid(User user) {
		//password strength check etc
		return true;
	}

}
