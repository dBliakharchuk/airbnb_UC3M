package logic;

import database.DataAccess;
import model.Message;
import model.Reservation;

public class MessageLogic {
	
	public static boolean sendMessage(Message msg) {
		if (msg == null) {
			return false;
		}
		
		//TODO JMS
		
		return DataAccess.createMessage(msg);
	}
	
}
