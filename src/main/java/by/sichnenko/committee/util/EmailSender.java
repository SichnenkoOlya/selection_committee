package by.sichnenko.committee.util;


import by.sichnenko.committee.exception.TechnicalException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailSender {

    private final static String FROM_EMAIL = "olencka11@yandex.ru";
    private final static String PASSWORD = "sichnenkoolay1998";
    private final static String EMAIL_SUBJECT = "Email";
    private static final String PROPERTIES_PATH = "resources/mail.properties";

    public static void sendEmail(String emailAddress, String emailText) throws TechnicalException {

        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fileInputStream = classLoader.getResourceAsStream(PROPERTIES_PATH);
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new TechnicalException("Error reading email properties", e);
        }
        Session session = Session.getDefaultInstance(properties,

                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
                    }
                });

        Message mess = new MimeMessage(session);
        try {
            mess.setFrom(new InternetAddress(FROM_EMAIL));
            mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
            mess.setSubject(EMAIL_SUBJECT);
            mess.setText("You are entered: " + emailText + "  ");
            Transport.send(mess);

        } catch (MessagingException e) {
            throw new TechnicalException("Error sending email", e);
        }
    }
}
