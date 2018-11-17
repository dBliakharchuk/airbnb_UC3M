package logic;

import database.DataAccess;
import model.Message;
import model.Reservation;
import model.User;

public class MessageLogic {
	
	public static boolean sendMessage(Message msg) {
		if (msg == null) {
			return false;
		}
		
		//TODO JMS
		
		return DataAccess.createMessage(msg);
	}
	
	public static boolean removeMessage(Message msg) {
		if (msg == null) {
			return false;
		}
		
		User sender = msg.getSender();
		sender.removeMessagesSent(msg);
		DataAccess.updateUser(sender);
		
		User receiver = msg.getReceiver();
		sender.addMessagesReceived(msg);
		DataAccess.updateUser(receiver);
		
		return DataAccess.removeMessage(msg);
	}
	
}
