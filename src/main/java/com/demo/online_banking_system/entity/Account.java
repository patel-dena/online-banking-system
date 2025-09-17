package com.demo.online_banking_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number", nullable = false)
    private User user;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Getter
    @Setter
    @Column(nullable = false)
    private String accountType;

    @Getter
    @Setter
    @Column(nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {}

    public Account(User user, String accountNumber, String accountType, BigDecimal balance) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
}
