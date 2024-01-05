package com.example.website13.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.mail")
public class EmailSenderProperties {
    private String host;
    private int port;
    private String username;
    private String password;
}
