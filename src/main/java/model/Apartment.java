package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the apartment database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Apartment.findAll", query="SELECT a FROM Apartment a"),
	@NamedQuery(name="Apartment.findByHost", query="SELECT a FROM Apartment a where a.id.host = :host"),
	@NamedQuery(name="Apartment.findByName", query="SELECT a FROM Apartment a where a.name = :name"),
	@NamedQuery(name="Apartment.findByCountry", query="SELECT a FROM Apartment a where a.country = :country"),
	@NamedQuery(name="Apartment.findByCity", query="SELECT a FROM Apartment a where a.id.city = :city"),
	@NamedQuery(name="Apartment.findCheaperThan", query="SELECT a FROM Apartment a where a.price <= :price")})
public class Apartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ApartmentPK id;
	
	@Column(name="beds_adult")
	private int bedsAdult;
	@Column(name="beds_child")
	private int bedsChild;
	private String country;
	private String description;
	private String name;
	@Lob
	private byte[] picture;
	private double price;
	private String type;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="host")
	private User host;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="apartment")
	private List<Reservation> reservations;

	public Apartment() {
	}

	public ApartmentPK getId() {
		return this.id;
	}

	public void setId(ApartmentPK id) {
		this.id = id;
	}

	public int getBedsAdult() {
		return this.bedsAdult;
	}

	public void setBedsAdult(int bedsAdult) {
		this.bedsAdult = bedsAdult;
	}

	public int getBedsChild() {
		return this.bedsChild;
	}

	public void setBedsChild(int bedsChild) {
		this.bedsChild = bedsChild;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getHost() {
		return this.host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setApartment(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setApartment(null);

		return reservation;
	}

}