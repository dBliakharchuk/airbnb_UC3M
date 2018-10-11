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
	
}
