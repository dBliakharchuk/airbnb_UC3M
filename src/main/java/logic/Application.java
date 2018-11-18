package logic;

import java.util.List;

import database.DataAccess;
import model.Apartment;
import model.Message;
import model.Reservation;
import model.User;

public class Application {
	
	public static void main(String[] args) {
//		removeReservationTest();
//		removeApartmentTest();
//		removeMessageTest();
//		removeUserTest();
//		sendMessageTest(DataAccess.getAllUsers().get(0), DataAccess.getAllUsers().get(1), "test");
//		MessageLogic.notifyReceiver(Message.createNewMessage(DataAccess.getAllUsers().get(0), DataAccess.getAllUsers().get(1), "test"));
	}
	
	private static void removeReservationTest() {
		List<Reservation> aps = DataAccess.getAllReservations();
		User cust = aps.get(0).getUser();
		System.out.println(DataAccess.getUserByEmail(cust.getEmail()).getReservations().size());
		boolean s = TripLogic.removeReservation(aps.get(0));
		System.out.println(s);
		System.out.println(DataAccess.getUserByEmail(cust.getEmail()).getReservations().size());
		
	}
	
	private static void removeApartmentTest() {
		List<Reservation> aps = DataAccess.getAllReservations();
		Apartment a = aps.get(0).getApartment();
		User cust = a.getHost();
		System.out.println(DataAccess.getUserByEmail(cust.getEmail()).getApartments().size());
		boolean s = ApartmentLogic.removeApartment(a);
		System.out.println(s);
		System.out.println(DataAccess.getUserByEmail(cust.getEmail()).getApartments().size());
		
	}
	
	private static void removeMessageTest() {
		User user = DataAccess.getUserByEmail("customer@gmail.com");
		System.out.println(user.getMessagesSent().size());
		boolean s = MessageLogic.removeMessage(user.getMessagesSent().get(0));
		System.out.println(s);
		System.out.println(user.getMessagesSent().size());
		
	}
	
	private static void removeUserTest() {
		User user = DataAccess.getUserByEmail("customer@gmail.com");
		System.out.println(DataAccess.getAllUsers().size());
		boolean s = UserLogic.removeUser(user);
		System.out.println(s);
		System.out.println(DataAccess.getAllUsers().size());
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
