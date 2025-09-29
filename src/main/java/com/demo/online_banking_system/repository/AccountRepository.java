package com.demo.online_banking_system.repository;

import com.demo.online_banking_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Retrieves accounts based on a user.
    Optional<Account> findByAccountNumber(String accountNumber);
}
