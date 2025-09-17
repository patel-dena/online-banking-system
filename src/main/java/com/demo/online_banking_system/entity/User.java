package com.demo.online_banking_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String usernumber;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false)
    private String phone;

    @Getter
    @Setter
    @Column(nullable = false)
    private String address;

    @Getter
    @Setter
    @Column(nullable = false)
    private String city;

    @Getter
    @Setter
    @Column(nullable = false)
    private String state;

    @Getter
    @Setter
    @Column(nullable = false)
    private String country;

    @Getter
    @Setter
    @Column(nullable = false)
    private String zipcode;

    @Getter
    @Setter
    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    public User() {
    }

    public User(String usernumber, String username, String password, String email,String phone, String address, String city, String state, String country, String zipcode, String role) {
        this.usernumber = usernumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.role = role;
    }
}
