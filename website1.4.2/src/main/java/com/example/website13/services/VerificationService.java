package com.example.website13.services;

import com.example.website13.models.VerificationEntity;
import com.example.website13.repositories.UserRepository;
import com.example.website13.repositories.VerificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationService {
    private final VerificationRepository verificationRepository;
    private final UserRepository userRepository;

    @Autowired
    public VerificationService(VerificationRepository verificationRepository, UserRepository userRepository) {
        this.verificationRepository = verificationRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createVerification(String email, int vcode) {
        verificationRepository.save(new VerificationEntity(email, vcode));
    }

    @Transactional
    public VerificationEntity verifyUser(String email, int vcode) {
        Optional<VerificationEntity> verification = verificationRepository.findByEmailAndCode(email, vcode);
        if(verification.isPresent())
            userRepository.updateRegistrationFinishedByEmail(email);
        return verification.orElse(null);
    }
}
