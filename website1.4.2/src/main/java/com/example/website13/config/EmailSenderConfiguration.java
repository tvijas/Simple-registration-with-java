package com.example.website13.config;
import com.example.website13.config.EmailSenderProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailSenderConfiguration {
private static EmailSenderProperties emailSenderProperties;
@Autowired
    public EmailSenderConfiguration(EmailSenderProperties emailSenderProperties) {
        this.emailSenderProperties = emailSenderProperties;
    }

    @Bean
    @PostConstruct
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailSenderProperties.getHost()); // Укажите хост SMTP-сервера
        mailSender.setPort(emailSenderProperties.getPort()); // Укажите порт
        mailSender.setUsername(emailSenderProperties.getUsername()); // Укажите свой email
        mailSender.setPassword(emailSenderProperties.getPassword()); // Укажите пароль от почты

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Устанавливает режим отладки, чтобы увидеть подробные журналы

        return mailSender;
    }
}
