/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Johna
 */
@Stateless
public class MailSenderEJB {

    public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message) throws AddressException{
        
                
        try {
        //Properties props = System.getProperties();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.user", username);
        
        Session mailSession = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);}
        });
        mailSession.setDebug(true);
        
        MimeMessage mailMessage = new MimeMessage(mailSession);
        mailMessage.setFrom(new InternetAddress(fromEmail));        
        mailMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
        mailMessage.setContent(message, "text/html");
        mailMessage.setSubject(subject);
        
        Transport.send(mailMessage);
        
        
        /*Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", 465, username, password);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();*/
        
        } catch (MessagingException ex) {
            Logger.getLogger(MailSenderEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
