package logic;

import database.DataAccess;
import model.Reservation;

public class TripLogic {
	
	public static boolean removeReservation(Reservation reservation) {
		if (reservation == null) {
			return false;
		}
		
		return DataAccess.removeReservation(reservation);
	}

}
