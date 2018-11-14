package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import database.DataAccess;
import model.Apartment;
import model.Reservation;
import model.User;

public class TripLogic {
	
	public static boolean removeReservation(Reservation reservation) {
		if (reservation == null) {
			return false;
		}
		
		return DataAccess.removeReservation(reservation);
	}
	
	

}
