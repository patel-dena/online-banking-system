package com.demo.online_banking_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
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

    @Data
    public static class TransactionRequest {
        @NotBlank(message = "Account number is required")
        private String accountNumber;

        @NotBlank(message = "Amount is required")
        @Positive(message = "Amount must be greater than zero")
        private double amount;
    }

    @Data
    public static class TransferRequest {
        @NotBlank(message = "From Account is required")
        private String fromAccount;

        @NotBlank(message = "To Account is required")
        private String toAccount;

        @NotBlank(message = "Amount is required")
        @Positive(message = "Amount must be greater than zero")
        private double amount;
    }
}
