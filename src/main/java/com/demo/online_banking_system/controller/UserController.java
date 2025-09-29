package com.demo.online_banking_system.controller;

import com.demo.online_banking_system.dto.UserDTO;
import com.demo.online_banking_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users.
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by user_name.
    @GetMapping("/{username}")
    public List<UserDTO> getUsersByName(@PathVariable String username) {
        return userService.getUsersByName(username);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserDTO.RegistrationRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserDTO.LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(token); // in real system return JWT
    }
}
