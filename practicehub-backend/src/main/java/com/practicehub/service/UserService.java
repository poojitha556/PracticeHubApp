package com.practicehub.service;

import org.springframework.stereotype.Service;
import com.practicehub.entity.User;
import com.practicehub.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register
    public User register(User user) {
        return userRepository.save(user);
    }

    // Find by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Login
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
