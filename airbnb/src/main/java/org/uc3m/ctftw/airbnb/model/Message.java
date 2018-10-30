package org.uc3m.ctftw.airbnb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message
{
	@ManyToOne
    @JoinColumn(nullable = false)
	private User sender;
	@ManyToOne
    @JoinColumn(nullable = false)
	private User receiver;
	@Column
	private Boolean isUnread;
	@Column(name = "message")
	private String content;
	@Column
	private Timestamp date;
	
	public Message(User sender, User receiver, Boolean isUnread, String content, Timestamp date) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.isUnread = isUnread;
		this.content = content;
		this.date = date;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Boolean getIsUnread() {
		return isUnread;
	}

	public void setIsUnread(Boolean isUnread) {
		this.isUnread = isUnread;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	
}
