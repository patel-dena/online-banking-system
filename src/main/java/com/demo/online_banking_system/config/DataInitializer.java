package com.demo.online_banking_system.config;

import com.demo.online_banking_system.entity.Account;
import com.demo.online_banking_system.entity.Transaction;
import com.demo.online_banking_system.entity.User;
import com.demo.online_banking_system.repository.AccountRepository;
import com.demo.online_banking_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   AccountRepository accountRepository) {
        return args -> {
            if (userRepository.count() == 0) {

                // Create User.
                User user = new User();
                user.setUsernumber("UB12345");
                user.setUsername("Riya");
                user.setPassword("Riya123");
                user.setEmail("Riya@example.com");
                user.setPhone("123456789");
                user.setAddress("2 Dayton Dr.");
                user.setCity("Edison");
                user.setState("NJ");
                user.setCountry("USA");
                user.setZipcode("08820");
                user.setRole("Admin");
                userRepository.save(user);

                // Account details.
                Account account = new Account();
                account.setUser(user);
                account.setAccountNumber("1234567890L");
                account.setAccountType("Savings");
                account.setBalance(new BigDecimal("2000"));
//                accountRepository.save(account);

                // Transaction details.
                Transaction T1 = new Transaction();
                T1.setAccount(account);
                T1.setAmount(new BigDecimal("1000"));
                T1.setDescription("Initial Deposit");
                T1.setTimestamp(LocalDateTime.now());
                T1.setStatus("Credit");
//                transactionRepository.save(T1);

                Transaction T2 = new Transaction();
                T2.setAccount(account);
                T2.setAmount(new BigDecimal("500"));
                T2.setDescription("Shopping");
                T2.setTimestamp(LocalDateTime.now());
                T2.setStatus("Debit");
//                transactionRepository.save(T2);

                // Link transactions to account
                account.addTransaction(T1);
                account.addTransaction(T2);

                // Save account (cascade saves transactions)
                accountRepository.save(account);

                System.out.println("Sample data imported successfully!");
            }
        };
    }
}
