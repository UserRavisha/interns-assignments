package ignitershub;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendingEmail {

    public static void main(String[] args) {
        String toEmail = "hr@ignitershub.com";
        String subject = "Challenge 3 Completed";
        String body = "Name: Ravisha Popli\nSemester: Diploma in Advance Computing\nBranch: CDAC Delhi\nRoll Number: 230310120025";

        // Replace these with your personal email credentials
        String fromEmail = "ravishapopli23@gmail.com";
        String password = "ahuja1022";

        // Replace the file path with the path to your image
        String imagePath = "C:\\Users\\abc\\Desktop\\image.jpg";

        sendEmail(toEmail, subject, body, fromEmail, password, imagePath);
    }

    public static void sendEmail(String toEmail, String subject, String body, String fromEmail, String password, String imagePath) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            // Create the message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Create the multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attach the image
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(imagePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(source.getName());
            multipart.addBodyPart(attachmentPart);

            // Set the complete message parts
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}