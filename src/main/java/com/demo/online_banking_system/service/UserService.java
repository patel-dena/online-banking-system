package com.demo.online_banking_system.service;

import com.demo.online_banking_system.dto.UserDTO;
import com.demo.online_banking_system.entity.User;
import com.demo.online_banking_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository  userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream().map(this::convertUserToDTO).collect(Collectors.toList());
    }

    public List<User> getUsersByName(String username) {
        return userRepository.findByUsername(username);
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
}
