# online-banking-system

Steps:
1. Initialize Spring Boot Project using Spring Initializr and add dependencies Spring Web, Spring Data JPA, Spring Security, MySQL Driver, Lombok, Validation.
2. Configure Application Properties by set up database connection (MySQL) and Configure JPA (hibernate.ddl-auto=update, show-sql=true).
3. Create Database Schema with banking_db database and No manual table creation (Spring JPA will create/update automatically).
4. Define Entity Classes: User, Account, Transaction.
5. Create JPA Repositories
6. Build Business Logic (Service Layer)
7. Create REST Controllers
