package org.example.mailingmailing;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailService {
    private static final String username = "john.lgd65@gmail.com";
    private static final String password = "duqwtogqjcbvafud";

    public static void main(String[] args) throws MessagingException {
        var session = getSession(username, password);
        var message = new MimeMessage(session);
        var recipient = "dev.jlkeesh@gmail.com";

        message.setSubject("This is Subject For Test Message");
        message.setContent("<h1 style=\"color:red;\">Body of mail here</h1>", "text/html");
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }


    private static Session getSession(final String username, final String password) {
        return Session.getInstance(getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
