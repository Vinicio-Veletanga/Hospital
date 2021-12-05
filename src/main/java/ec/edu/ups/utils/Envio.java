package ec.edu.ups.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.Dotenv;

public class Envio {
	
	private static Dotenv dotenv = Dotenv.configure().directory("/ec/edu/ups/utils").load();
	
	private static String correoOrigen = dotenv.get("USER_EMAIL");
	
	public static void envioCorreo(String correoDestino, String name, String lastName, String password) throws IOException {
		
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		 properties.put("mail.smtp.host", host);
	     properties.put("mail.smtp.port", "587");
	     properties.put("mail.smtp.starttls.enable","true");
	     properties.put("mail.smtp.auth", "true");
	     
	     Session session = Session.getInstance(properties,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(correoOrigen, dotenv.get("EMAIL_PASSWORD"));
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(correoOrigen));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(correoDestino)
	            );
	            message.setSubject("Password Cuenta");
	            message.setText("Dear "+ name.concat(" " + lastName) +","
	                    + "\n\n Usted puede usar su email "+ correoDestino +", "
	                    + "\n\n Esta es su password: " + password);

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	     
	    
	}

}
