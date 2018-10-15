package org.uc3m.ctftw.airbnb.model;

import java.util.List;

public class User
{
	private String email;
	private String name;
	private String surname;
	private String password;
	
	private List<Trip> userTrips;
	private List<Message> messagesReceived;

	public User(String email, String name, String surname, String password)
	{
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getPasswaord()
	{
		return password;
	}

	public void setPasswaord(String passwaord)
	{
		this.password = passwaord;
	}

}
