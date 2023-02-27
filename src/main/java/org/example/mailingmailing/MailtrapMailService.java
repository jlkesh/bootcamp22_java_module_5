package org.example.mailingmailing;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Properties;

public class MailtrapMailService {
    private static final String username = "638d61bc2999aa";
    private static final String password = "12a704d155cbbb";

    public static void main(String[] args) throws Exception {

        var session = getSession();
        var message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("recipient@gmail.com"));
        message.setSubject("This is Subject For Test Message");
        var multipart = new MimeMultipart();

        var attachment1 = new MimeBodyPart();
        var fileDataSource = new FileDataSource("cv.txt");
        var dataHandler = new DataHandler(fileDataSource);
        attachment1.setFileName("MyCv.txt");
        attachment1.setDataHandler(dataHandler);


        var attachment2 = new MimeBodyPart();
        var fileDataSource2 = new FileDataSource("samples.txt");
        var dataHandler2 = new DataHandler(fileDataSource2);
        attachment2.setFileName("CodeSamples.txt");
        attachment2.setDataHandler(dataHandler2);

        var attachment3 = new MimeBodyPart();
        attachment3.setContent("""
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                </head>
                <body>
                <h1>Hello, world!</h1>
                <img src="data:image/png;base64, %s" alt="Mushuklar">
                </body>
                </html>
                """.formatted(getImage()),"text/html");


//        multipart.addBodyPart(attachment1);
//        multipart.addBodyPart(attachment2);
        multipart.addBodyPart(attachment3);
        message.setContent(multipart);
        Transport.send(message);
        System.out.println("Message Sent Successfully");
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.mailtrap.io");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }


    public static String getImage() throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        Path path = Path.of("img.png");
        byte[] bytes = Files.readAllBytes(path);
        return encoder.encodeToString(bytes);
    }


    private static Session getSession() {
        return Session.getInstance(getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
