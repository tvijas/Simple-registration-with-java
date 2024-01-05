package com.example.website13.controllers;

import com.example.website13.models.User;
import com.example.website13.services.UserService;
import com.example.website13.util.LoginValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final LoginValidator loginValidator;

    @Autowired
    public LoginController(UserService userService, LoginValidator loginValidator) {
        this.userService = userService;
        this.loginValidator = loginValidator;
    }

    @GetMapping()
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "/LoginView";
    }

    @PostMapping()
    public String login(@ModelAttribute User user, BindingResult bindingResult) {
        loginValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "LoginView";
        return "RegIsFinished";
    }
}