package com.example.website13.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "userdata")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String email;
    private String password;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Column(name = "registration_finished", columnDefinition = "INT DEFAULT 0")
    private boolean registrationFinished;
    public UserEntity (User user){
        setLogin(user.getLogin());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setRegistrationDate(user.getLocalDate());
    }
}
