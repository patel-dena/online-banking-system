package com.demo.online_banking_system.service;

import com.demo.online_banking_system.dto.AccountDTO;
import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream().map(this::convertAccountToDTO).collect(Collectors.toList());
    }

    public List<AccountDTO> getAccountByAccountNumber(String accountNumber) {
        List<Account> account = accountRepository.findByAccountNumber(accountNumber);

        return account.stream().map(this::convertAccountToDTO).collect(Collectors.toList());
    }

    private AccountDTO convertAccountToDTO(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getUser().getUsername()
        );
    }
}
