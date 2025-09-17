package com.demo.online_banking_system.dto;

import lombok.Getter;

import java.math.BigDecimal;

public class AccountDTO {

    @Getter
    private Long id;

    @Getter
    private String accountNumber;

    @Getter
    private String accountType;

    @Getter
    private BigDecimal balance;

    @Getter
    private String username;

    public AccountDTO(Long id, String accountNumber, String accountType, BigDecimal balance, String username) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.username = username;
    }
}
