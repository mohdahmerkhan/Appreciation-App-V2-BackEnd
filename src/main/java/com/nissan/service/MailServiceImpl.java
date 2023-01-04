package com.nissan.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nissan.dto.Mail;
import com.nissan.repo.IUserRepo;

@Service
public class MailServiceImpl implements IMailService{

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	IUserRepo userRepo;
	
	@Override
	public String sendEmail(Mail mail)
	{
		  
		  return "Under Construction";
	}
	
	
	@Override
	public String sendEmailWithAttachments(Mail mail, int templateID, String[] tags) throws MessagingException, javax.mail.MessagingException
	{
		MimeMessage message = mailSender.createMimeMessage();
		
        MimeMessageHelper msgHelper = new MimeMessageHelper(message, true);
		
//        mail.setFrom(mail.getFrom());
        msgHelper.setFrom(mail.getFrom());
        msgHelper.setTo(mail.getTo());
        msgHelper.setCc(mail.getCcTo());
        msgHelper.setSubject(mail.getSubject());

        
        StringBuilder htmlContent = new StringBuilder();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("C:/Users/NDH00788/Documents/workspace-STS/AppreciationApp/src/main/resources/templates/template_"+templateID+".html"));
            String htmlContentLine;
            
            while ((htmlContentLine = in.readLine()) != null)
            {
                htmlContent.append(htmlContentLine);
            }
            in.close();
        }
        catch (IOException e)
        {
        	e.printStackTrace();
        }
        String content = htmlContent.toString();
        
        
        content = content.replace("RecieverName", userRepo.findNameByEmail(mail.getTo()));
        content = content.replace("SenderName", userRepo.findNameByEmail(mail.getFrom()));
        
        StringBuilder values = new StringBuilder("");
        
        for(int i=0;i<tags.length-1;i++)
        {
        	values.append(tags[i] + " , ");
        }

        if(tags.length > 1)
        {
        	values.append(" and ");
        }
        values.append(tags[tags.length-1]);
      
        content = content.replace("valueArray", values.toString());
       
        System.out.println(content);
        System.out.println(mail);
        
        msgHelper.setText(content, true);
        //msgHelper.addAttachment("Minion's Photo is Here.jpg", new ClassPathResource("minion.jpg"));

        //mailSender.send(message);
        
        return "Success with attachment";
	}
}
