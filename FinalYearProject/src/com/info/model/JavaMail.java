package com.info.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class JavaMail 
{
	public static void sendMail( String email,int empid) throws Exception
	{
	    final String username = "moupiidriss@gmail.com";
	    final String password = "lebossemti@2015";
	    String recipient = email;
	    
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.from", "moupiidriss@gmail.com");
	    //props.put("mail.from", "sumit.java1001@gmail.com");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.port", "587");
	    props.setProperty("mail.smtp.debug", "true");
	    
	    Session session1 = Session.getInstance(props, null);  // step 1
	    
	    MimeMessage msg = new MimeMessage(session1);          // step 2
		
	    msg.setRecipients(Message.RecipientType.TO, recipient);
	    msg.setSubject("Confirmation your registration ");
	    msg.setText(" click on the folowing ling to confirm your registration : http://localhost:8080/FinalYearProject/validate?empid="+empid);

	    Transport transport = session1.getTransport("smtp");   // step 3
	    transport.connect(username, password);
	    transport.sendMessage(msg, msg.getAllRecipients());
	    transport.close();
	    System.out.println("Mail sent successfully!!!!!!!");
	}

}

