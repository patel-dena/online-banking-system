package com.demo.online_banking_system.service;

import com.demo.online_banking_system.dto.TransactionDTO;
import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.entity.Transaction;
import com.demo.online_banking_system.repository.AccountRepository;
import com.demo.online_banking_system.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream().map(this::convertTransactionToDTO).collect(Collectors.toList());
    }

    public List<TransactionDTO> getTransactionByAccountNumber(String accountNumber) {
        List<Account> account = accountRepository.findByAccountNumber(accountNumber);

        List<Transaction> transaction = transactionRepository.findByAccount(account.get(0));

        return transaction.stream().map(this::convertTransactionToDTO).collect(Collectors.toList());
    }

    private TransactionDTO convertTransactionToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getTimestamp(),
                transaction.getStatus(),
                transaction.getAccount().getAccountNumber()
        );
    }
}
