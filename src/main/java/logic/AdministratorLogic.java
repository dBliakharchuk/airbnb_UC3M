package logic;

import model.User;

public class AdministratorLogic
{
	public static Boolean updateUserData(User updatedUser)
	{
		if(updatedUser.getEmail() != "")
			return true;
		return false;
	}
}
