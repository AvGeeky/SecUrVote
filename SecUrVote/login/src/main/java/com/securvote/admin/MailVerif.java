package com.securvote.admin;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;
public class MailVerif {


    public static void mailsender(String recipient, Map<String,Integer> voteCount, String electionName) {

        Dotenv dotenv = Dotenv.configure()
                .filename("apiee.env")
                .load();
        String username = dotenv.get("MAIL_ID");
        String password = dotenv.get("MAIL_PASSKEY");
        String sender = username;

        String host = "smtp.gmail.com";


        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Port 587 for TLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3"); // Enable TLSv1.2 and TLSv1.3
        properties.put("mail.smtp.connectiontimeout", "5000");
        properties.put("mail.smtp.timeout", "5000");
        properties.put("mail.smtp.writetimeout", "5000");// Enable TLS encryption


        // Creating a new session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Creating a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Setting From field
            message.setFrom(new InternetAddress(sender));

            // Adding recipient to the message
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject("SecUrVote Election Results");

            message.setSubject("SecUrVote Election Results");


            String htmlContent = "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: auto; padding: 20px; border: 1px solid #e0e0e0; border-radius: 10px; color: #333;'>"
                    + "<table width='100%' cellpadding='0' cellspacing='0' style='border-collapse: collapse;'>"
                    + "<tr><td style='text-align: center;'><h2 style='color: #4CAF50;'>SecUrVote Election Results - " + electionName + "</h2></td></tr>"
                    + "<tr><td><hr style='border: none; border-top: 2px solid #4CAF50;'></td></tr>"
                    + "<tr><td style='padding-top: 20px;'></td></tr>"
                    + "<tr><td style='color: #333;'>Dear User,</td></tr>"
                    + "<tr><td style='padding-top: 10px; color: #333;'>We are pleased to share the results of the election conducted via <b>SecUrVote</b>. Below are the final tallies for the " + electionName + ":</td></tr>"
                    + "<tr><td style='padding-top: 20px;'></td></tr>"
                    + "<tr><td style='text-align: center;'>"
                    + "<table style='width: 100%; border-collapse: collapse; margin: 20px 0; text-align: left;'>"
                    + "<thead>"
                    + "<tr style='background-color: #4CAF50; color: white;'>"
                    + "<th style='padding: 10px; border: 1px solid #ddd;'>Candidate</th>"
                    + "<th style='padding: 10px; border: 1px solid #ddd;'>Votes</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>";

// Dynamically populate results here
            for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
                htmlContent += "<tr>"
                        + "<td style='padding: 10px; border: 1px solid #ddd;'>" + entry.getKey() + "</td>"
                        + "<td style='padding: 10px; border: 1px solid #ddd; text-align: center;'>" + entry.getValue() + "</td>"
                        + "</tr>";
            }

            htmlContent += "</tbody>"
                    + "</table>"
                    + "</td></tr>"
                    + "<tr><td style='padding-top: 20px; color: #333;'>Thank you for participating in the " + electionName + " and for your trust in <b>SecUrVote</b>. We look forward to serving you again in the future.</td></tr>"
                    + "<tr><td style='padding-top: 10px; color: #333;'>For any queries, please feel free to contact our support team.</td></tr>"
                    + "<tr><td style='padding-top: 20px; color: #333;'>Best Regards,<br><b>SecUrVote Team</b></td></tr>"
                    + "<tr><td style='padding-top: 20px;'></td></tr>"
                    + "<tr><td style='padding-top: 20px; border-top: 1px solid #e0e0e0;'>"
                    + "<p style='font-size: 12px; color: #999; text-align: center;'>"
                    + "This is an automated email, please do not reply. For support, visit our website."
                    + "</p>"
                    + "</td></tr>"
                    + "</table>"
                    + "</div>";




            // Setting the email content
            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Sending the email
            Transport.send(message);
            //System.out.println("Mail successfully sent with OTP!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void mailsender(String recipient, String otp) {
        Dotenv dotenv = Dotenv.configure()
                .filename("apiee.env")
                .load();
        String username = dotenv.get("MAIL_ID");
        String password = dotenv.get("MAIL_PASSKEY");

        String sender = username; // Your Gmail address

        String host = "smtp.gmail.com";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Port 587 for TLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3"); // Enable TLSv1.2 and TLSv1.3
        properties.put("mail.smtp.connectiontimeout", "5000");
        properties.put("mail.smtp.timeout", "5000");
        properties.put("mail.smtp.writetimeout", "5000");// Enable TLS encryption

        // Creating a new session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Creating a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Setting From field
            message.setFrom(new InternetAddress(sender));

            // Adding recipient to the message
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Setting the subject of the email
            message.setSubject("Your One-Time Password (OTP) for SecUrVote");

            String htmlContent = "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: auto; padding: 20px; border: 1px solid #e0e0e0; border-radius: 10px; color: #333;'>"
                    + "<table width='100%' cellpadding='0' cellspacing='0' style='border-collapse: collapse;'>"
                    + "<tr><td style='text-align: center;'><h2 style='color: #4CAF50;'>SecUrVote</h2></td></tr>"
                    + "<tr><td><hr style='border: none; border-top: 2px solid #4CAF50;'></td></tr>"
                    + "<tr><td style='padding-top: 20px;'></td></tr>"
                    + "<tr><td style='color: #333;'>Dear User,</td></tr>"
                    + "<tr><td style='padding-top: 10px; color: #333;'>Thank you for using <b>SecUrVote</b>. To complete your action, please use the following One-Time Password (OTP):</td></tr>"
                    // Adding space before OTP box
                    + "<tr><td style='padding-top: 20px;'></td></tr>"
                    + "<tr><td style='text-align: center; margin: 20px;'>"
                    + "<span style='display: inline-block; background-color: #f2f2f2; padding: 15px 30px; font-size: 24px; font-weight: bold; color: #333; border-radius: 8px; letter-spacing: 4px;'>"
                    + otp
                    + "</span>"
                    + "</td></tr>"
                    + "<tr><td style='padding-top: 20px; color: #333;'>This OTP is only valid for <b>one login</b>. Please do not share this OTP with anyone for security reasons.</td></tr>"
                    + "<tr><td style='padding-top: 10px; color: #333;'>If you did not request this, please ignore this email or contact our support team immediately.</td></tr>"
                    + "<tr><td style='padding-top: 20px; color: #333;'>Best Regards,<br><b>SecUrVote Team</b></td></tr>"
                    + "<tr><td style='padding-top: 20px;'></td></tr>"
                    + "<tr><td style='padding-top: 20px; border-top: 1px solid #e0e0e0;'>"
                    + "<p style='font-size: 12px; color: #999; text-align: center;'>"
                    + "This is an automated email, please do not reply. For support, visit our website."
                    + "</p>"
                    + "</td></tr>"
                    + "</table>"
                    + "</div>";






            // Setting the email content
            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Sending the email
            Transport.send(message);
            //System.out.println("Mail successfully sent with OTP!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public static int sendMail(String mail){
        final int otp;
        Random random = new Random();
        otp = 100000 + random.nextInt(900000);
        MailVerif.mailsender(mail,String.valueOf(otp));
        return otp;
    }

  

}



