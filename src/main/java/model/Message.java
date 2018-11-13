package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MessagePK id;
	private boolean isUnread;

	@ManyToOne
	@JoinColumn(name="receiver")
	private User sender;

	@ManyToOne
	@JoinColumn(name="sender")
	private User receiver;

	public Message() {
	
	}

	public Message(User sender, User receiver, Date date, String message) {
		this.id = new MessagePK(message, date, sender.getEmail(), receiver.getEmail());
		this.isUnread = true;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public static Message createNewMessage(User sender, User receiver, String message) {
		Date date = new Date();
		return new Message(sender, receiver, date, message);
	}

	public MessagePK getId() {
		return this.id;
	}

	public void setId(MessagePK id) {
		this.id = id;
	}

	public boolean getIsUnread() {
		return this.isUnread;
	}

	public void setIsUnread(boolean isUnread) {
		this.isUnread = isUnread;
	}

	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
		id.setSender(sender.getEmail());
	}

	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
		id.setReceiver(receiver.getEmail());
	}
	
	public String getMessage() {
		return id.getMessage();
	}
	
	public void setMessage(String message) {
		id.setMessage(message);
	}
	
	public Date getDate() {
		return id.getDate();
	}
	
	public void setDate(Date date) {
		id.setDate(date);
	}

	@Override
	public String toString() {
		return "Message [id=" + id.toString() + ", isUnread=" + isUnread + ", sender=" + sender + ", receiver=" + receiver + "]";
	}
	
	

}