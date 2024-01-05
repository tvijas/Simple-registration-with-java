package com.example.website13.services;
import com.example.website13.models.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    final JavaMailSender javaMailSender;

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(MailTemplate mailTemplate) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("tvijasss@gmail.com");
            message.setTo(mailTemplate.getToEmail());
            message.setSubject(mailTemplate.getSubject());
            message.setText(mailTemplate.getBody());

            javaMailSender.send(message);

            System.out.println("Email sent successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
