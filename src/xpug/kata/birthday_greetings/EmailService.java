package xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {

	void sendMessage(Greetings greetings) throws AddressException, MessagingException;

}