package org.uc3m.ctftw.airbnb.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Localization
{
	private String country;
	private String city;
	private String street;
	private int buildingNumber;
	private int flatNumber;
	
	public String getHash() {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		byte[] message = (country + city + street + String.valueOf(buildingNumber) + String.valueOf(flatNumber)).getBytes(StandardCharsets.UTF_8);
		byte[] byteHash = digest.digest(message);
		return new String(byteHash);
	}
	
	

	public Localization(String country, String city, String street, int buildingNumber, int flatNumber)
	{
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.flatNumber = flatNumber;
	}



	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public int getBuildingNumber()
	{
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber)
	{
		this.buildingNumber = buildingNumber;
	}

	public int getFlatNumber()
	{
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber)
	{
		this.flatNumber = flatNumber;
	}
	
	
	
	
}
