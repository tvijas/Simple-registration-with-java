package com.example.website13.services;

import com.example.website13.models.User;
import com.example.website13.models.UserEntity;
import com.example.website13.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntity checkLogin(String login) {
        Optional<UserEntity> user = userRepository.findByLogin(login);
        return user.orElse(null);
    }

    @Transactional
    public UserEntity checkEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.saveAndFlush(new UserEntity(user));
    }

    @Transactional
    public UserEntity login(String login, String password) {
        Optional<UserEntity> user = userRepository.findByLoginAndPasswordAndRegistrationFinishedIsTrue(login, password);
        return user.orElse(null);
    }
}
