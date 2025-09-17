package com.demo.online_banking_system.controller;

import com.demo.online_banking_system.dto.TransactionDTO;
import com.demo.online_banking_system.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Get all transactions.
    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get user by user_name.
    @GetMapping("/account/{accountNumber}")
    public List<TransactionDTO> getTransactionByAccountNumber(@PathVariable String accountNumber) {
        return transactionService.getTransactionByAccountNumber(accountNumber);
    }
}
