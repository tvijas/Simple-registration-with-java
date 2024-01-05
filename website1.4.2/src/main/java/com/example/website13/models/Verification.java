package com.example.website13.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Verification {
    private String email;
    private int vcode;
    public Verification(String email) {
        this.email = email;
    }
}
