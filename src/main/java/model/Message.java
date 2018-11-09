package model;

import java.io.Serializable;
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

	private byte isUnread;

	@ManyToOne
	@JoinColumn(name="receiver")
	private User sender;

	@ManyToOne
	@JoinColumn(name="sender")
	private User receiver;

	public Message() {
	}

	public MessagePK getId() {
		return this.id;
	}

	public void setId(MessagePK id) {
		this.id = id;
	}

	public byte getIsUnread() {
		return this.isUnread;
	}

	public void setIsUnread(byte isUnread) {
		this.isUnread = isUnread;
	}

	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

}