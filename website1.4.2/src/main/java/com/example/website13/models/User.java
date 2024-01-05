package com.example.website13.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


import java.time.LocalDate;

@Data
public class User {
    @NotBlank(message = "Login should not be empty")
    @Size(min =6, max = 20, message = "Login must contain from 6 to 20 symbols")
    private String login;
    @Email(message = "Email doesn't exist")
    @NotBlank( message = "Email should not be empty")
    private String email;
    @Size(min = 6,message = ("Minimum password size is 6 symbols"))
    private String password;
    private LocalDate localDate;

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.localDate = LocalDate.now();
    }
    public User() {
        this.localDate = LocalDate.now();
    }
}
