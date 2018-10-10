package org.uc3m.ctftw.airbnb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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

}
