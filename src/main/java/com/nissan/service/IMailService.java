package com.nissan.service;

import com.nissan.dto.Mail;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

public interface IMailService
{
	//Send Email
	public String sendEmail(Mail mail);
	
	//Send Email with Attachments
	public String sendEmailWithAttachments(Mail mail, int templateIDc, String[] tags) throws MessagingException, javax.mail.MessagingException, javax.mail.MessagingException;
	
}
