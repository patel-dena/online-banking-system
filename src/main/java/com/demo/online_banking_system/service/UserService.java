package com.demo.online_banking_system.service;

import com.demo.online_banking_system.dto.UserDTO;
import com.demo.online_banking_system.entity.User;
import com.demo.online_banking_system.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository  userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream().map(this::convertUserToDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByName(String username) {
        Optional<User> user =  userRepository.findByUsername(username);
        return user.stream().map(this::convertUserToDTO).collect(Collectors.toList());
    }

    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(
                user.getUsernumber(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getCity(),
                user.getState(),
                user.getCountry(),
                user.getZipcode(),
                user.getRole()
        );
    }

    // Register a new user
    public void registerUser(UserDTO.RegistrationRequest request) {
        Optional<User> user =  userRepository.findByUsername(request.getUsername());
        if (user.isPresent()) {
            throw new RuntimeException("Username already taken: " + request.getUsername());
        }

        User user1 = new User();
        user1.setUsername(request.getUsername());
        user1.setPassword(passwordEncoder.encode(request.getPassword()));
        user1.setEmail(request.getEmail());

        userRepository.save(user1);
    }

    // Login (return token stub for now)
    public String login(UserDTO.LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // 🔹 For now just return a fake token, later integrate JWT
        return "FAKE-JWT-TOKEN-FOR-" + user.getUsername();
    }
}
