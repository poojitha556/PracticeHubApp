package com.practicehub.controller;

import com.practicehub.entity.User;
import com.practicehub.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            return "Email already exists";
        }

        userService.register(user);
        return "User registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User loginRequest) {

        User user = userService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            response.put("status", "success");
            response.put("userId", user.getId());
            response.put("username", user.getUsername());
            response.put("email", user.getEmail());
        } else {
            response.put("status", "failure");
            response.put("message", "Invalid email or password");
        }

        return response;
    }
}
