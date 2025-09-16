package com.demo.online_banking_system.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class AccountDTO {

    @Getter
    private List<UserDTO> users;

    @Getter
    private Long id;

    @Getter
    private String accountNumber;

    @Getter
    private String accountType;

    @Getter
    private BigDecimal balance;

    @Getter
    private List<TransactionDTO> transactions;

    public AccountDTO(List<UserDTO> users, Long id, String accountNumber, String accountType, BigDecimal balance, List<TransactionDTO> transactions) {
        this.users = users;
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = transactions;
    }
}
