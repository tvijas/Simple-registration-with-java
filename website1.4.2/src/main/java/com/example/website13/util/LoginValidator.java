package com.example.website13.util;

import com.example.website13.models.User;
import com.example.website13.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
    private final UserService userService;

    @Autowired
    public LoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.login(user.getLogin(), user.getPassword()) == null) {
            errors.rejectValue("login", "", "login or password is incorrect");
            System.out.println("CHECKED");
        }
    }
}
