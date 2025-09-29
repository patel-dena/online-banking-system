package com.demo.online_banking_system.service;

import com.demo.online_banking_system.dto.AccountDTO;
import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.entity.User;
import com.demo.online_banking_system.exception.InsufficientFundsException;
import com.demo.online_banking_system.repository.AccountRepository;
import com.demo.online_banking_system.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream().map(this::convertAccountToDTO).collect(Collectors.toList());
    }

    public List<AccountDTO> getAccountByAccountNumber(String accountNumber) {
        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        return account.stream().map(this::convertAccountToDTO).collect(Collectors.toList());
    }

    public AccountDTO convertAccountToDTO(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getUser().getUsername()
        );
    }

    @Transactional
    public Account createAccount(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        Account account = new Account();
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(BigDecimal.valueOf(0));
        account.setUser(user);

        return accountRepository.save(account);
    }

    // Deposit
    @Transactional
    public Account deposit(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found: " + accountNumber));

        account.setBalance(account.getBalance().add(BigDecimal.valueOf(amount)));
        return accountRepository.save(account);
    }

    // Withdraw
    @Transactional
    public Account withdraw(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found: " + accountNumber));

        if (account.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new InsufficientFundsException("Insufficient funds in account: " + accountNumber);
        }

        account.setBalance(account.getBalance().subtract(BigDecimal.valueOf(amount)));
        return accountRepository.save(account);
    }

    // Transfer
    @Transactional
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new RuntimeException("Source account not found: " + fromAccountNumber));

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new RuntimeException("Target account not found: " + toAccountNumber));

        if (fromAccount.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new InsufficientFundsException("Insufficient funds in source account: " + fromAccountNumber);
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(BigDecimal.valueOf(amount)));
        toAccount.setBalance(toAccount.getBalance().add(BigDecimal.valueOf(amount)));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
