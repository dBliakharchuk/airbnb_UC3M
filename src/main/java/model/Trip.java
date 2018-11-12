package model;

import java.util.Date;
import java.util.List;

public class Trip {
	Date beginning;
	Date end;
	List<Reservation> reservations;
	
	public Trip() {
		
	}
	
	public Trip(Date beginning, Date end, List<Reservation> reservations) {
		super();
		this.beginning = beginning;
		this.end = end;
		this.reservations = reservations;
	}

	public Date getBeginning() {
		return beginning;
	}

	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
}
