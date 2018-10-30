package org.uc3m.ctftw.airbnb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Apartment")
public class Apartment
{
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	@JoinColumn(name = "email", nullable = false)
	private User host;	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Localization localization;
	@Column(name = "price", nullable = false)
	private double price;
	@Column
	private String type;
	@Column(name = "beds_adult")
	private int bedsAdult;
	@Column(name = "beds_child")
	private int bedsChild;
	
	@OneToMany(mappedBy="apartment")
	private List<Reservation> bookedDays;

	public Apartment(String name, String description, User host, Localization localization, double price, String type,
			int bedsAdult, int bedsChild, List<Reservation> bookedDays) {
		super();
		this.name = name;
		this.description = description;
		this.host = host;
		this.localization = localization;
		this.price = price;
		this.type = type;
		this.bedsAdult = bedsAdult;
		this.bedsChild = bedsChild;
		this.bookedDays = bookedDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public Localization getLocalization() {
		return localization;
	}

	public void setLocalization(Localization localization) {
		this.localization = localization;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBedsAdult() {
		return bedsAdult;
	}

	public void setBedsAdult(int bedsAdult) {
		this.bedsAdult = bedsAdult;
	}

	public int getBedsChild() {
		return bedsChild;
	}

	public void setBedsChild(int bedsChild) {
		this.bedsChild = bedsChild;
	}

	public List<Reservation> getBookedDays() {
		return bookedDays;
	}

	public void setBookedDays(List<Reservation> bookedDays) {
		this.bookedDays = bookedDays;
	}
	
	

	

}
