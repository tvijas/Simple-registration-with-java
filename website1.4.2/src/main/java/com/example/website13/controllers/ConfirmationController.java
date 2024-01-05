package com.example.website13.controllers;

import com.example.website13.models.Verification;
import com.example.website13.services.UserService;
import com.example.website13.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/confirmation")
public class ConfirmationController {
    private final VerificationService verificationService;

    @Autowired
    public ConfirmationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping()
    public String confirmationPage(@RequestParam("email") String email, Model model) {
        model.addAttribute("verification", new Verification(email));
        return "/ConfirmationView";
    }

    @PostMapping()
    public String confirmationRequest(@ModelAttribute Verification vm) {
        System.out.println(vm.getEmail() + "    " + vm.getVcode());
        if (verificationService.verifyUser(vm.getEmail(), vm.getVcode()) != null) {
            return "/RegIsFinished";
        } else {
            return "redirect:/confirmation?email=" + vm.getEmail();
        }
    }
}
