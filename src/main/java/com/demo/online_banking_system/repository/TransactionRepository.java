package com.demo.online_banking_system.repository;

import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Retrieves transactions for a specific account.
    List<Transaction> findByAccount(Account account);
}
