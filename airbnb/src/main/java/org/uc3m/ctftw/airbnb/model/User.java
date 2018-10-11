package model;

public class User
{
	private String email;
	private String name;
	private String surname;
	private String passwaord;

	public User(String email, String name, String surname, String passwaord)
	{
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.passwaord = passwaord;
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
		return passwaord;
	}

	public void setPasswaord(String passwaord)
	{
		this.passwaord = passwaord;
	}

}