package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByEmail", query="SELECT u FROM User u where u.email = :email"),
	@NamedQuery(name="User.findBySurname", query="SELECT u FROM User u where u.surname = :surname") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String name;
	private String password;
	private String phone;
	private String surname;

	@OneToMany(mappedBy="host")
	private List<Apartment> apartments;

	@OneToMany(mappedBy="sender")
	private List<Message> messagesSent;

	@OneToMany(mappedBy="receiver")
	private List<Message> messagesReceived;

	@OneToMany(mappedBy="user")
	private List<Reservation> reservations;

	public User() {
	}
	
	
	

	public User(String email, String name, String phone, String surname)
	{
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.surname = surname;
	}




	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Apartment> getApartments() {
		return this.apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	public Apartment addApartment(Apartment apartment) {
		getApartments().add(apartment);
		apartment.setHost(this);

		return apartment;
	}

	public Apartment removeApartment(Apartment apartment) {
		getApartments().remove(apartment);
		apartment.setHost(null);

		return apartment;
	}

	public List<Message> getMessagesSent() {
		return this.messagesSent;
	}

	public void setMessagesSent(List<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}

	public Message addMessagesSent(Message messagesSent) {
		getMessagesSent().add(messagesSent);
		messagesSent.setSender(this);

		return messagesSent;
	}

	public Message removeMessagesSent(Message messagesSent) {
		getMessagesSent().remove(messagesSent);
		messagesSent.setSender(null);

		return messagesSent;
	}

	public List<Message> getMessagesReceived() {
		return this.messagesReceived;
	}

	public void setMessagesReceived(List<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}

	public Message addMessagesReceived(Message messagesReceived) {
		getMessagesReceived().add(messagesReceived);
		messagesReceived.setReceiver(this);

		return messagesReceived;
	}

	public Message removeMessagesReceived(Message messagesReceived) {
		getMessagesReceived().remove(messagesReceived);
		messagesReceived.setReceiver(null);

		return messagesReceived;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setUser(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setUser(null);

		return reservation;
	}

}