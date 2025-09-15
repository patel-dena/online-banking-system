package com.demo.online_banking_system.repository;

import com.demo.online_banking_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Useful for authentication later.
    Optional<User> findByUsername(String username);

    // Helps prevent duplicate users.
    boolean existsByEmail(String email);
}
