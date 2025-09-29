package com.demo.online_banking_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

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

    @Data
    public static class RegistrationRequest {
        @NotBlank(message = "Usernumber is required")
        private String usernumber;

        @NotBlank(message = "Username is required")
        private String username;

        @NotBlank(message = "Password is required")
        private String password;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "Phone is required")
        private String phone;

        @NotBlank(message = "Address is required")
        private String address;

        @NotBlank(message = "City is required")
        private String city;

        @NotBlank(message = "State is required")
        private String state;

        @NotBlank(message = "Country is required")
        private String country;

        @NotBlank(message = "Zipcode is required")
        private String zipcode;

        @NotBlank(message = "Role is required")
        private String role;
    }

    @Data
    public static class LoginRequest {
        @NotBlank(message = "Username is required")
        private String username;

        @NotBlank(message = "Password is required")
        private String password;
    }
}
