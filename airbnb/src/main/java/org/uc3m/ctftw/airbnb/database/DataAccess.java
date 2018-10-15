package org.uc3m.ctftw.airbnb.database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.uc3m.ctftw.airbnb.model.Apartment;
import org.uc3m.ctftw.airbnb.model.Message;
import org.uc3m.ctftw.airbnb.model.Trip;
import org.uc3m.ctftw.airbnb.model.User;

public class DataAccess 
{
	private static Connection connection;
	

	public static void initialize()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/sampledb?autoReconnect=true&useSSL=false", "userLQE",
					"2dAlhk2RqPhVlFOK");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users;");

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next())
			{
				for (int i = 1; i <= columnsNumber; i++)
				{
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}

			if (rs != null)
			{
				rs.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static User getUserByEmail(String email) {
		return null;
	}
	
	public static User getUserByNameAndSurname(String name, String surname) {
		return null;
	}
	
	public static List<Apartment> getAllApartments() {
		return null;
	}
	
	public static Apartment getApartmentByName(String name) {
		return null;
	}
	
	public static List<Message> getUserMessages(User user) {
		return null;
	}
	
	public static List<Trip> getUserTrips(User user) {
		return null;
	}
	

}
