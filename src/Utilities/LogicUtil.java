/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Dell
 */
public class LogicUtil {
    //Gửi mã về email

    public void codeVerification(String email, String random) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tuannmph17935@fpt.edu.vn", "ebtdnurnvqxawzcl");
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Google"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );

            message.setSubject("Mã xác nhận mật khẩu [" + random + "]");
            message.setText("Mã xác nhận quên mật khẩu của Phần Mềm Quản Lý Bán Xe Máy");
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace(System.out);
        }
    }
    
        // Mã hóa password
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            String myHash = DatatypeConverter.printHexBinary(messageDigest).toUpperCase();
            return myHash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public String taoMaHoa(String password) {
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        return md5Hex;
    }
}
