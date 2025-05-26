# Expensely – Personal & Group Finance Tracker

Expensely is a full-stack finance management application designed to help individuals and groups track their income, expenses, budgets, shared group expenses, and settlements efficiently. It is built using Angular for the frontend and Spring Boot with MongoDB for the backend.

This README covers the backend development progress up to the implementation of the centralized transaction microservice and its integration with the Income module.

---

## 📌 Tech Stack

* Backend: Spring Boot, Spring Data MongoDB, Spring Security, JWT
* Database: MongoDB
* Frontend: Angular (setup completed, integration in progress)
* Architecture: Modular microservice-style structure within a monorepo
* Communication: Internal service calls using RestTemplate (can later migrate to Feign or event-based system)

---

## ✅ Completed Backend Features

### 1. User Authentication & Authorization

* JWT-based login and registration.
* Passwords securely hashed.
* AuthController for login and registration endpoints.

### 2. User Management

* User IDs auto-generated (e.g., 25U0001, 25U0002).
* Endpoints:

    * POST /api/users — create user
    * GET /api/users — list all users
    * GET /api/users/{userId} — get user by ID

### 3. Expense Module

* Users can track personal expenses.
* CRUD operations secured via JWT.
* Linked to user IDs.

### 4. Income Module (Integrated with Transaction Service)

* Allows users to add/view/update/delete income entries.
* When income is created, a corresponding credit Transaction is created automatically.
* Transaction Service is called using RestTemplate.

Endpoints:

* POST /api/income — Add income (triggers transaction creation)
* GET /api/income/user/{userId} — Get all incomes by user
* GET /api/income/{id} — Get income by ID
* PUT /api/income/{id} — Update income
* DELETE /api/income/{id} — Delete income

### 5. Centralized Transaction Microservice ✅

A unified service to handle all financial transactions (debits and credits) across the application. Replaces the need for duplicate logic in income, expense, and group modules.

Transaction fields:

* id: Auto-generated in the format TXN0001, TXN0002...
* userId
* groupId (optional)
* type: CREDIT / DEBIT (Enum)
* amount
* category, subCategory
* account
* description
* timestamp

Endpoints:

* POST /api/transactions — Create a transaction
* GET /api/transactions/user/{userId} — Get all transactions for a user
* GET /api/transactions/{id} — Get transaction by ID

Implementation details:

* Transaction IDs generated via a TransactionIdGenerator based on MongoDB count.
* Used by IncomeService (and will be used by GroupExpense, etc.).

---

## 🔧 Project Structure (Backend)

* config — JWT, security filters, Mongo config
* auth — Authentication logic (JWT, login, register)
* users — User management
* income — Income tracking (with transaction integration)
* transactions — Centralized transaction service
* expenses — Personal expenses
* budgets — Budget planning
* groups, groupExpenses — Group and shared expense modules (in progress)

---

## 🚧 In Progress

* Group Expense module to use centralized transaction service
* Settlements & payment tracking
* Angular frontend integration
* Dashboard, reports, and PDF exports

---

## 🛠️ Setup Instructions

1. Clone the repository.
2. Make sure MongoDB is running locally or update the URI in application.properties.
3. Run the Spring Boot application.
4. Use Postman or Swagger to test APIs.

---
