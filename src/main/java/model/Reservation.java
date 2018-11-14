package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservationPK id;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="apartmentBuildingNumber", referencedColumnName="buildingNumber"),
		@JoinColumn(name="apartmentCity", referencedColumnName="city"),
		@JoinColumn(name="apartmentFlatNumber", referencedColumnName="flatNumber"),
		@JoinColumn(name="apartmentHost", referencedColumnName="host"),
		@JoinColumn(name="apartmentStreet", referencedColumnName="street")
		})
	private Apartment apartment;

	@ManyToOne
	@JoinColumn(name="userEmail")
	private User user;

	public Reservation() {
	
	}

	public Reservation(ReservationPK id, Apartment apartment, User user) {
		super();
		this.id = id;
		this.apartment = apartment;
		this.user = user;
	}
	
	public Reservation(User user, Apartment apartment, Date date) {
		this.id = new ReservationPK(user, apartment, date);
		this.apartment = apartment;
		this.user = user;
	}

	public ReservationPK getId() {
		return this.id;
	}

	public void setId(ReservationPK id) {
		this.id = id;
	}

	public Date getDate() {
		return id.getDate();
	}

	public void setDate(Date date) {
		id.getDate();
	}

	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
		id.setApartmentBuildingNumber(apartment.getBuildingNumber());
		id.setApartmentCity(apartment.getCity());
		id.setApartmentFlatNumber(apartment.getFlatNumber());
		id.setApartmentHost(apartment.getHost().getEmail());
		id.setApartmentStreet(apartment.getStreet());
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
		id.setUserEmail(user.getEmail());
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id.toString() + ", apartment=" + apartment + ", user=" + user + "]";
	}
	
	

}