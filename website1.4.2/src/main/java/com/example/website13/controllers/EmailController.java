package com.example.website13.controllers;

import com.example.website13.models.MailTemplate;
import com.example.website13.services.EmailSenderService;
import com.example.website13.services.VerificationService;
import com.example.website13.util.VerificationCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/email")
public class EmailController {
    private final EmailSenderService emailSenderService;
private final VerificationCodeGenerator verificationCodeGenerator;
private final VerificationService verificationService;
    @Autowired
    public EmailController(EmailSenderService emailSenderService, VerificationCodeGenerator verificationCodeGenerator, VerificationService verificationService) {
        this.emailSenderService = emailSenderService;
        this.verificationCodeGenerator = verificationCodeGenerator;
        this.verificationService = verificationService;
    }

    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    public String sendEmail(@RequestParam String toEmail) {
        MailTemplate mailTemplate = new MailTemplate();
        int vcode = verificationCodeGenerator.generateCode();
        mailTemplate.setStandardEmailTemplate(toEmail, vcode);
        emailSenderService.sendEmail(mailTemplate);
        verificationService.createVerification(toEmail, vcode);
        return "redirect:/confirmation?email=" + toEmail;
    }

}
