package com.demo.online_banking_system.controller;

import com.demo.online_banking_system.dto.UserDTO;
import com.demo.online_banking_system.entity.User;
import com.demo.online_banking_system.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> getUsersByName(@PathVariable String username) {
        return userService.getUsersByName(username);
    }
}
