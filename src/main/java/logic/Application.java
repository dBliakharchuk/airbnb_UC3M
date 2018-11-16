package logic;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import database.DataAccess;
import model.Apartment;
import model.ApartmentPK;
import model.ApartmentType;
import model.Message;
import model.Reservation;
import model.ReservationPK;
import model.Trip;
import model.User;

public class Application {
	
	public static void main(String[] args) {
//		boolean success = UserLogic.registerUser(null);
//		boolean success2 = ApartmentLogic.addApartment(null);
//		boolean success3 = MessageLogic.sendMessage(null);
//		boolean success4 = TripLogic.bookTrip(null);
//		
//		boolean success5 = UserLogic.modifyUser(null);
//		boolean success6 = ApartmentLogic.modifyApartment(null);
//		//boolean success7 = DataAccess.updateMessage(null);
//		//boolean success8 = DataAccess.updateReservation(null);
//
//		boolean success9 = UserLogic.removeUser("");
//		//boolean success10 = ApartmentLogic.removeApartment(null);
//		//boolean success11 = DataAccess.removeMessage(null);
//		boolean success12 = TripLogic.removeReservation(null);
//		
//		System.out.println(success);
//		System.out.println(success2);
//		System.out.println(success3);
//		System.out.println(success4);
//		
//		System.out.println(success5);
//		System.out.println(success6);
//		//System.out.println(success7);
//		//System.out.println(success8);
//		
//		System.out.println(success9);
//		//System.out.println(success10);
//		//System.out.println(success11);
//		System.out.println(success12);
		
//		List<Apartment> aps = DataAccess.getAllApartments();
//		User piotr = DataAccess.getUserByEmail("customer@gmail.com");
//		User mat = DataAccess.getUserByEmail("mateusz@gmail.com");
//		UserLogic.deleteUser(piotr);
//		List<Trip> trips = TripLogic.getUserTrips(piotr);
//		System.out.println(trips.size());
		
//		for (Trip t : trips) {
//			System.out.println(t.getBeginning() + " " + t.getEnd());
//		}
//		List<User> users = DataAccess.getAllUsers();
//		List<Reservation> reservs = DataAccess.getAllReservations();
//		//ApartmentPK apKey = new ApartmentPK("dima@gmail.com", "15", "Calle Central", "5", "Madrid");
//		
		//DataAccess.createMessage(new Message(piotr, mat, new Date(), "test"));
		
//		Apartment toReserve = null;
//		User customer = null;
//		Reservation res = null;
//		
//		for (Apartment a : aps) {
//			if (a.getStreet().equals("Gran Via")) {
//				toReserve = a;
//				break;
//			}
//		}
//		for (User u : users) {
//			if (u.getEmail().equals("customer@gmail.com")) {
//				customer = u;
//				break;
//			}
//		}
//		for (Reservation r : reservs) {
//			if (r.getUser().getEmail().equals("customer@gmail.com") && r.getApartment().getStreet().equals("Gran Via")) {
//				res = r;
//				break;
//			}
//		}
				
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
