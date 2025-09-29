package com.demo.online_banking_system.controller;

import com.demo.online_banking_system.dto.AccountDTO;
import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Get all accounts.
    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Get user by user_name.
    @GetMapping("/{accountNumber}")
    public List<AccountDTO> getAccountByAccountNumber(@PathVariable String accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }

    // Create new account
    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestParam String username) {
        Account account = accountService.createAccount(username);
        return ResponseEntity.ok(accountService.convertAccountToDTO(account));
    }

    // Deposit
    @PostMapping("/deposit")
    public ResponseEntity<Account> deposit(@Valid @RequestBody AccountDTO.TransactionRequest request) {
        Account updatedAccount = accountService.deposit(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok(updatedAccount);
    }

    // Withdraw
    @PostMapping("/withdraw")
    public ResponseEntity<Account> withdraw(@RequestBody AccountDTO.TransactionRequest request) {
        Account updatedAccount = accountService.withdraw(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok(updatedAccount);
    }

    // Transfer
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody AccountDTO.TransferRequest request) {
        accountService.transfer(request.getFromAccount(), request.getToAccount(), request.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }
}
