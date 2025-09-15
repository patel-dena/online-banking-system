package com.demo.online_banking_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Getter
    @Setter
    @Column(nullable = false)
    private BigDecimal amount;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Getter
    @Setter
    @Column(nullable = false)
    private String status;

    public Transaction() {}

    public Transaction(Account account, BigDecimal amount, String description, LocalDateTime timestamp, String status) {
        this.account = account;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.status = status;
    }
}
