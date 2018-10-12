package org.uc3m.ctftw.airbnb.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Apartment
{
	private String name;
	private String description;
	private User host;
	private Localization localization;
	private BigDecimal pricePerDay;
	private String typeOfApartment;
	private int bedsAdult;
	private int bedsChild;
	
	private List<Date> bookedDays;

	public Apartment(String name, String description, User host, Localization localization, BigDecimal pricePerDay,
			String typeOfApartment, int bedsAdult, int bedsChild, List<Date> bookedDays)
	{
		super();
		this.name = name;
		this.description = description;
		this.host = host;
		this.localization = localization;
		this.pricePerDay = pricePerDay;
		this.typeOfApartment = typeOfApartment;
		this.bedsAdult = bedsAdult;
		this.bedsChild = bedsChild;
		this.bookedDays = bookedDays;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public User getHost()
	{
		return host;
	}

	public void setHost(User host)
	{
		this.host = host;
	}

	public Localization getLocalization()
	{
		return localization;
	}

	public void setLocalization(Localization localization)
	{
		this.localization = localization;
	}

	public BigDecimal getPricePerDay()
	{
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay)
	{
		this.pricePerDay = pricePerDay;
	}

	public String getTypeOfApartment()
	{
		return typeOfApartment;
	}

	public void setTypeOfApartment(String typeOfApartment)
	{
		this.typeOfApartment = typeOfApartment;
	}

	public int getBedsAdult()
	{
		return bedsAdult;
	}

	public void setBedsAdult(int bedsAdult)
	{
		this.bedsAdult = bedsAdult;
	}

	public int getBedsChild()
	{
		return bedsChild;
	}

	public void setBedsChild(int bedsChild)
	{
		this.bedsChild = bedsChild;
	}

	public List<Date> getBookedDays()
	{
		return bookedDays;
	}

	public void setBookedDays(List<Date> bookedDays)
	{
		this.bookedDays = bookedDays;
	}
	
	
	
	

}
