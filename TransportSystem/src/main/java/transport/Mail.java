package transport;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Mail {
	static String sendMail(String host,String sub, String massageBody) {
		//1st step) Get the session object    
				Properties pro = new Properties();  
				pro.put("mail.smtp.auth",true);
				pro.put("mail.smtp.starttls.enable", true);
				pro.put("mail.smtp.port",587);
				pro.put("mail.smtp.host","smtp.gmail.com");
				Session instance=Session.getInstance(pro, new Authenticator()
				{
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("pukharajlol2018@gmail.com","kjrxrsecfbwfrobu");
				}}); 
				//2nd step)compose message 
				try {  
				 Message message = new MimeMessage(instance);  
				 message.setRecipient(Message.RecipientType.TO,new InternetAddress(host));
				 message.setFrom(new InternetAddress("pukharajlol2018@gmail.com"));  
				 message.setSubject(sub);  
				 message.setText(massageBody);     
				 Transport.send(message);  
				    return "Mail Send  successfully!!!!00";
				 } catch (Exception e) {  
				    e.printStackTrace();  
				    return "mail not send";
				 }  
	}
}
