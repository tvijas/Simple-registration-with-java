package com.example.website13.controllers;


import com.example.website13.models.User;
import com.example.website13.services.UserService;
import com.example.website13.util.RegistrationValidator;
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
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;
    private final RegistrationValidator registrationValidator;

    @Autowired
    public RegistrationController(UserService userService, RegistrationValidator registrationValidator) {
        this.userService = userService;
        this.registrationValidator = registrationValidator;
    }

    @GetMapping()
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "/RegistrationView";
    }

    @PostMapping()
    public String addUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        registrationValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "/RegistrationView";
        userService.save(user);
        return "redirect:/email/send?toEmail=" + user.getEmail();
    }
}
