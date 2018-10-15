package org.uc3m.ctftw.airbnb.model;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Hex;	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Localization
{
	private String country;
	private String city;
	private String street;
	private String buildingNumber;
	private String flatNumber;
	
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
	
	

	public Localization(String country, String city, String street, String buildingNumber, String flatNumber)
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

	public String getBuildingNumber()
	{
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber)
	{
		this.buildingNumber = buildingNumber;
	}

	public String getFlatNumber()
	{
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber)
	{
		this.flatNumber = flatNumber;
	}
	
	
	
	
}
