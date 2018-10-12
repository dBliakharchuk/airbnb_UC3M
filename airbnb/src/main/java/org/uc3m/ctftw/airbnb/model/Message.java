package org.uc3m.ctftw.airbnb.model;

import java.sql.Date;

public class Message
{
	private Boolean messageIsUnred;
	private String content;
	private Date date;
	
	public Message(Boolean messageIsUnred, String content, Date date)
	{
		super();
		this.messageIsUnred = messageIsUnred;
		this.content = content;
		this.date = date;
	}

	public Boolean getMessageIsUnred()
	{
		return messageIsUnred;
	}

	public void setMessageIsUnred(Boolean messageIsUnred)
	{
		this.messageIsUnred = messageIsUnred;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	

}
