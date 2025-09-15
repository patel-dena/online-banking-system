package com.demo.online_banking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankingController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello World");
        return "Banking system is running.";
    }
}
