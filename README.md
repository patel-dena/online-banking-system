# online-banking-system

Steps:
1. Initialize Spring Boot Project using Spring Initializr and add dependencies Spring Web, Spring Data JPA, Spring Security, MySQL Driver, Lombok, Validation.
2. Configure Application Properties by set up database connection (MySQL) and Configure JPA (hibernate.ddl-auto=update, show-sql=true).
3. Create Database Schema with banking_db database and No manual table creation (Spring JPA will create/update automatically).
4. Define Entity Classes: User, Account, Transaction.
5. Create JPA Repositories
6. Build Business Logic (Service Layer)
7. Create REST Controllers


# Online Banking System (Spring Boot)

A simple **online banking system** built with **Java, Spring Boot, Spring Data JPA, and MySQL**.  
This project implements core banking operations like **account creation, deposit, withdrawal, transfer, and transaction history**.

---

## 🚀 Features
- User & Account management
- Deposit, Withdraw, and Transfer operations
- Transaction history API
- REST API with Spring Boot
- MySQL database integration
- Clean layered architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- Maven

---

## ⚙️ Setup Instructions
1. Clone the repository  
   git clone https://github.com/patel-dena/online-banking-system.git
   cd online-banking-system

2. Configure MySQL in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Build & Run
mvn spring-boot:run


## 📡 API Endpoints

Users
GET /api/users/{username} → Get user by user_name
POST /api/users/register → Register User
POST /api/users/login → Login User

Accounts
GET /api/accounts/{accountNumber} → Get account details
POST /api/accounts/create → Create new account
POST /api/accounts/deposit → Deposit money
POST /api/accounts/withdraw → Withdraw money
POST /api/accounts/transfer → Transfer money

Transactions
GET /api/transactions/account/{accountNumber} → Get transaction history by account number

