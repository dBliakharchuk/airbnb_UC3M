package org.uc3m.ctftw.airbnb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "User")
public class User
{
	@Id
	@Column(nullable = false)
	private String email;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Reservation> userTrips;
	@OneToMany(mappedBy="receiver")
	private List<Message> messagesReceived;
	@OneToMany(mappedBy="sender")
	private List<Message> messagesSent;
	@OneToMany(mappedBy="host")
	private List<Apartment> apartments;
	
	public User(String email, String name, String surname, String password, List<Reservation> userTrips,
			List<Message> messagesReceived, List<Message> messagesSent, List<Apartment> apartments) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.userTrips = userTrips;
		this.messagesReceived = messagesReceived;
		this.messagesSent = messagesSent;
		this.apartments = apartments;
	}
	
	
	public User(String email, String name, String surname, String password) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Reservation> getUserTrips() {
		return userTrips;
	}
	public void setUserTrips(List<Reservation> userTrips) {
		this.userTrips = userTrips;
	}
	public List<Message> getMessagesReceived() {
		return messagesReceived;
	}
	public void setMessagesReceived(List<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}
	public List<Message> getMessagesSent() {
		return messagesSent;
	}
	public void setMessagesSent(List<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}
	public List<Apartment> getApartments() {
		return apartments;
	}
	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}
	
	
	
}
