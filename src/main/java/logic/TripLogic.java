package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import database.DataAccess;
import model.Apartment;
import model.Reservation;
import model.Trip;
import model.User;

public class TripLogic {
	
	public static boolean removeReservation(Reservation reservation) {
		if (reservation == null) {
			return false;
		}
		
		return DataAccess.removeReservation(reservation);
	}
	
	public static List<Trip> getUserTrips(User user) {
		List<Reservation> userReservations = user.getReservations();
		List<Trip> userTrips = new ArrayList<>();
		
		Collections.sort(userReservations);
		
		Reservation last = null;
		Trip trip = null;
		
		for (Reservation r : userReservations) {
			if (last == null || DateUtils.getDatesBetween(r.getDate(), last.getDate()).size() > 1) {
				if (trip != null) {
					userTrips.add(trip);
				}
				
				trip = new Trip();
				trip.setBeginning(r.getDate());
				trip.addReservation(r);
				last = r;
				
			} else {
				trip.addReservation(r);
				trip.setEnd(r.getDate());
				last = r;
			}
		}
		
		if (trip != null) {
			userTrips.add(trip);
		}
		
		return userTrips;	
	}

}
