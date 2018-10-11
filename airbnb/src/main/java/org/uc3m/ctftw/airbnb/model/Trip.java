package model;

import java.net.URL;
import java.sql.Date;

public class Trip
{
	private String name;
	private String typeOfApartment;
	private Date moveInDate;
	private Date moveOutDate;
	private URL photo;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getTypeOfApartment()
	{
		return typeOfApartment;
	}
	public void setTypeOfApartment(String typeOfApartment)
	{
		this.typeOfApartment = typeOfApartment;
	}
	public Date getmoveInDate()
	{
		return moveInDate;
	}
	public void setmoveInDate(Date moveInDate)
	{
		this.moveInDate = moveInDate;
	}
	public Date getmoveOutDate()
	{
		return moveOutDate;
	}
	public void setmoveOutDate(Date moveOutDate)
	{
		this.moveOutDate = moveOutDate;
	}
	public URL getPhoto()
	{
		return photo;
	}
	public void setPhoto(URL photo)
	{
		this.photo = photo;
	}
	public Trip(String name, String typeOfApartment, Date moveInDate, Date moveOutDate, URL photo)
	{
		super();
		this.name = name;
		this.typeOfApartment = typeOfApartment;
		this.moveInDate = moveInDate;
		this.moveOutDate = moveOutDate;
		this.photo = photo;
	}

}
