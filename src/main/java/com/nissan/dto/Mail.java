package com.nissan.dto;

import java.util.Arrays;

public class Mail
{
	//Data Fields
	private String to;
	private String from;
	private String subject;
	private String[] ccTo;
	private String body;
	
	//Default Constructor
	public Mail()
	{
	}
	
	//Parameterized Constructor
	public Mail(String to, String from, String subject, String[] ccTo, String body)
	{
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.ccTo = ccTo;
		this.body = body;
	}
	
	//Getters & Setters
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getCcTo() {
		return ccTo;
	}
	public void setCcTo(String[] ccTo) {
		this.ccTo = ccTo;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return String.format("Mail [to=%s, from=%s, subject=%s, ccTo=%s, body=%s]", to, from, subject,
				Arrays.toString(ccTo), body);
	}
	
	
	
}
