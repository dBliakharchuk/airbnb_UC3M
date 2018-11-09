package logic;

import java.util.List;

import database.DataAccess;
import model.User;

public class Application {
	
	public static void main(String[] args) {
		List<User> users = DataAccess.getAllUsers();
		for (User u : users) {
			System.out.println(u.getEmail());
		}
		
		User user = DataAccess.getUserByEmail("piotrszylar@gmail.com");
		System.out.println(user.getName());
	}

}
