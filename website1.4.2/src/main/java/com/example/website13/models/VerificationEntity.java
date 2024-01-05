package com.example.website13.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "verification")
public class VerificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @Column (name = "verification_code")
    private int code;
    public VerificationEntity(String email, int vcode){
        this.email = email;
        this.code = vcode;
    }
}

