package com.example.website13.util;

import com.example.website13.models.User;
import com.example.website13.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {
    private final UserService userService;

    @Autowired
    public RegistrationValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.checkEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "", "This email is already taken");
        }
        if (userService.checkLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "", "This login is already taken");
        }
    }
}
