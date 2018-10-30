package org.uc3m.ctftw.airbnb.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Hex;

@Entity
@Table(name = "Localization")
public class Localization
{
	@Column
	private String country;
	@Column
	private String city;
	@Column
	private String street;
	@Column(name = "building_number")
	private String buildingNumber;
	@Column(name = "flat_number")
	private String flatNumber;
	@OneToMany(mappedBy="localization")
	private List<Apartment> apartments;
	
	@Id
	@Column(name = "id")
	public String getHash() {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		byte[] message = (country + city + street + buildingNumber + flatNumber).getBytes(StandardCharsets.UTF_8);
		byte[] byteHash = digest.digest(message);
		return Hex.encodeHexString(byteHash);
	}

	public Localization(String country, String city, String street, String buildingNumber, String flatNumber,
			List<Apartment> apartments) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.flatNumber = flatNumber;
		this.apartments = apartments;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}
	
	
	
	
	
	
}
