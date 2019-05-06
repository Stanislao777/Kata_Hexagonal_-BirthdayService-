package xpug.kata.birthday_greetings;

import static java.util.Arrays.asList;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPMailService implements EmailService {

	private String smtpHost;
	private int smtpPort;

	public SMTPMailService(String smtpHost, int smtpPort) {
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
	}
	
	@Override
	public void sendMessage(Greetings greetings) throws AddressException, MessagingException {
		
		System.out.println("Email sent to: " + asList(greetings.getSender(), greetings.getSubject(), greetings.getBody(), greetings.getReceiver()));

		// Create a mail session
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getDefaultInstance(props, null);

		// Construct the message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(greetings.getSender()));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(greetings.getReceiver()));
		msg.setSubject(greetings.getSubject());
		msg.setText(greetings.getBody());

		// Send the message
		Transport.send(msg);
	}

}
