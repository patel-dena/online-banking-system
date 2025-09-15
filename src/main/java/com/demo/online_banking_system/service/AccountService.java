package com.demo.online_banking_system.service;

import com.demo.online_banking_system.dto.AccountDTO;
import com.demo.online_banking_system.dto.TransactionDTO;
import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.entity.Transaction;
import com.demo.online_banking_system.entity.User;
import com.demo.online_banking_system.repository.AccountRepository;
import com.demo.online_banking_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public List<AccountDTO> getAccountsByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found" + username);
        }

        List<Account> accounts = accountRepository.findByUser(user.get());
        return accounts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private AccountDTO convertToDTO(Account account) {
        List<TransactionDTO> transactions = account.getTransactions().stream()
                .map(this::convertTransactionToDTO)
                .collect(Collectors.toList());

        return new AccountDTO(
                account.getId(),
                account.getAccountType(),
                account.getBalance(),
                transactions
        );
    }

    private TransactionDTO convertTransactionToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getTimestamp(),
                transaction.getStatus()
        );
    }
}
