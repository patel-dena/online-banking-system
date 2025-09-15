package com.demo.online_banking_system.controller;

import com.demo.online_banking_system.dto.AccountDTO;
import com.demo.online_banking_system.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{username}")
    public List<AccountDTO> getAccounts(@PathVariable String username) {
        return accountService.getAccountsByUsername(username);
    }
}
