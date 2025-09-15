package com.demo.online_banking_system.repository;

import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Retrieves accounts based on a user.
    List<Account> findByUser(User user);
}
