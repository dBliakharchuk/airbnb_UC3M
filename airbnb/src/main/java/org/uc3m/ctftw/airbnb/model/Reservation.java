package org.uc3m.ctftw.airbnb.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {

	@ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
	private Apartment apartment;
	@ManyToOne
    @JoinColumn(name = "account_email", nullable = false)
	private User user;
	@Column
	private Date date;
	
	public Reservation(Apartment apartment, User user, Date date) {
		super();
		this.apartment = apartment;
		this.user = user;
		this.date = date;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
