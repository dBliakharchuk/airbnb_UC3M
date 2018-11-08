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

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userEmail")
	private User user;

	//bi-directional many-to-one association to Apartment
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="apartmentBuildingNumber", referencedColumnName="buildingNumber"),
		@JoinColumn(name="apartmentCity", referencedColumnName="city"),
		@JoinColumn(name="apartmentFlatNumber", referencedColumnName="flatNumber"),
		@JoinColumn(name="apartmentHost", referencedColumnName="host"),
		@JoinColumn(name="apartmentStreet", referencedColumnName="street")
		})
	private Apartment apartment;

	public Reservation() {
	}

	public ReservationPK getId() {
		return this.id;
	}

	public void setId(ReservationPK id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

}