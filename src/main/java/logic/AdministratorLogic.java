package logic;

import model.User;

public class AdministratorLogic
{
	public static Boolean updateUserData(User updatedUser)
	{
		if(updatedUser.getEmail() != "")
		{
			return true;
		}
			
		return false;
	}
	
	public static int updateUserPassword(String email, String password)
	{
		int status = 1;
		
		return status;
	}
	
	public static int deleteUser(String email)
	{
		int status = 1;
		
		return status;
	}
}


