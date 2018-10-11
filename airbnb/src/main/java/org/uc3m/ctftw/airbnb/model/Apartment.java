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
	private int beds;
	
	private List<Date> bookedDays;
	
	

}
