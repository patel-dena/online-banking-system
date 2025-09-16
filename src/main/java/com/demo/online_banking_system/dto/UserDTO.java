package com.demo.online_banking_system.dto;

import lombok.Getter;

import java.util.List;

public class UserDTO {

    @Getter
    private String usernumber;

    @Getter
    private String username;

    @Getter
    private String email;

    @Getter
    private String phone;

    @Getter
    private String address;

    @Getter
    private String city;

    @Getter
    private String state;

    @Getter
    private String country;

    @Getter
    private String zipcode;

    @Getter
    private String role;

    public UserDTO(String usernumber, String username, String email,String phone, String address, String city, String state, String country, String zipcode, String role) {
        this.usernumber = usernumber;
        this.username = username;
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
