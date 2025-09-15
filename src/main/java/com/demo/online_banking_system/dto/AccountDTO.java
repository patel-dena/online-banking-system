package com.demo.online_banking_system.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class AccountDTO {

    @Getter
    private Long id;

    @Getter
    private String accountType;

    @Getter
    private BigDecimal balance;

    @Getter
    private List<TransactionDTO> transactions;

    public AccountDTO(Long id, String accountType, BigDecimal balance, List<TransactionDTO> transactions) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = transactions;
    }
}
