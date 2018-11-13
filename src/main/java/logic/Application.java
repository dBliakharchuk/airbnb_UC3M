package logic;

import java.util.List;

import database.DataAccess;
import model.Apartment;
import model.ApartmentPK;
import model.ApartmentType;
import model.Message;
import model.User;

public class Application {
	
	public static void main(String[] args) {
		
		List<Apartment> aps = DataAccess.getAllApartments();
		//User piotr = DataAccess.getUserByEmail("piotrszylar@gmail.com");		
		User host = new User("test@gmail.com", "Test", "Kowalski", "kowal", "8993945939");
		User sender = DataAccess.getAllUsers().get(0);
		User receiver = DataAccess.getAllUsers().get(1);
		
		Apartment apartment = new Apartment(host,"3A", "Koszykowa", "2", "Warszawa", 3, 0, "Polska", "test", "Przyklad", new byte[2], 30.0, ApartmentType.PRIVATE_ROOM);
		ApartmentPK apKey = new ApartmentPK("dima@gmail.com", "15", "Calle Central", "5", "Madrid");
		
		//Apartment found = DataAccess.getApartmentById(apKey);
		
		//System.out.println(found.getCity());
		User found = DataAccess.getUserByEmail("mateusz@gmail.com");
		//removeUserTest(host);
		
		//sendMessageTest(sender, receiver, "test message");
		
		//updateUserTest(piotr);
		
		//System.out.println(DataAccess.getUserByEmail("sadw"));
		
	}
	
	private static void addApartmentTest(Apartment apartment, User host) {
		List<Apartment> apartments = DataAccess.getAllApartments();
		System.out.println("Jest tyle: " + apartments.size());
		boolean succededUser = DataAccess.createUser(host);
		boolean succededApartment = DataAccess.createApartment(apartment);
		System.out.println(succededUser + "  " + succededApartment);
		List<Apartment> apartmentsAfter = DataAccess.getAllApartments();
		System.out.println("Teraz jest tyle: " + apartmentsAfter.size());
		
	}
	
	private static void removeApartmentTest(Apartment apartment) {
		List<Apartment> apartments = DataAccess.getAllApartments();
		System.out.println("Jest tyle: " + apartments.size());
		boolean succededApartment = DataAccess.removeApartment(apartment);
		System.out.println(succededApartment);
		List<Apartment> apartmentsAfter = DataAccess.getAllApartments();
		System.out.println("Teraz jest tyle: " + apartmentsAfter.size());
		
	}
	
	private static void removeUserTest(User user) {
		List<User> users = DataAccess.getAllUsers();
		System.out.println("Jest tyle: " + users.size());
		boolean succededUser = DataAccess.removeUser(user);
		System.out.println(succededUser);
		List<User> usersAfter = DataAccess.getAllUsers();
		System.out.println("Teraz jest tyle: " + usersAfter.size());
		
	}
	
	private static void updateUserTest(User user) {
		User before = DataAccess.getUserByEmail(user.getEmail());
		System.out.println(before.getName());
		before.setName(before.getName() + "test");
		DataAccess.updateUser(before);
		User after = DataAccess.getUserByEmail(user.getEmail());
		System.out.println(after.getName());
	}
	
	private static void sendMessageTest(User sender, User receiver, String message) {
		Message toSend = Message.createNewMessage(sender, receiver, message);
		User send = DataAccess.getUserByEmail(sender.getEmail());
		User rec = DataAccess.getUserByEmail(receiver.getEmail());
		
		System.out.println("messages sent: " + send.getMessagesSent().size());
		System.out.println("messages received: " + rec.getMessagesReceived().size());
		
		DataAccess.createMessage(toSend);
		
		send = DataAccess.getUserByEmail(sender.getEmail());
		rec = DataAccess.getUserByEmail(receiver.getEmail());
		
		System.out.println("MESSAGE SENT");
		System.out.println("messages sent: " + send.getMessagesSent().size());
		System.out.println("messages received: " + rec.getMessagesReceived().size());
	}

}
