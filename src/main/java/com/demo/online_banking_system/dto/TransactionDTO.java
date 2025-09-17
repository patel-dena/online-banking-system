package com.demo.online_banking_system.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

    @Getter
    private Long id;

    @Getter
    private BigDecimal amount;

    @Getter
    private String description;

    @Getter
    private LocalDateTime timestamp;

    @Getter
    private String status;

    @Getter
    private String accountNumber;

    public TransactionDTO(Long id, BigDecimal amount, String description, LocalDateTime timestamp, String status, String accountNumber) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.status = status;
        this.accountNumber = accountNumber;
    }
}
