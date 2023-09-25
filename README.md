<h1 align="center">🌟 Spring-Boot-Microservices-Banking-Application 🌟</h1>

<p align="center">
  Welcome to the Spring Boot Microservices Banking Application! This project showcases a robust banking system built using Spring Boot microservices.
</p>

<h2 align="center">📋 Table of Contents</h2>

- [🚀 Functionalities](#-functionalities)
  - [🔍 Service Registry](#-service-registry)
  - [🌐 API Gateway](#-api-gateway)
  - [👤 User Service](#-user-service)
  - [💼 Account Service](#-account-service)
  - [💸 Fund Transfer Service](#-fund-transfer-service)
  - [💳 Transaction Service](#-transaction-service)
- [🚀 Getting Started](#-getting-started)
- [📖 Documentation](#-documentation)
- [🤝 Contribution](#-contribution)

---

<h2 align="center">🚀 Functionalities</h2>

### 🔍 Service Registry
- Manages microservices for easy discovery and registration.

### 🌐 API Gateway
- Provides a single entry point to the microservices and handles routing.

### 👤 User Service
- **Registration of User:** Register users with the banking system.
- **Reading All Users:** Retrieve a list of all registered users.
- **Reading User by ID:** Retrieve user details based on their unique ID.
- **Reading User by account Id:** Reterive user details based on their account ID.
- **Update User Status**: Modify the user detials based on the user request.

### 💼 Account Service
- **Creating an Account:** Users can create bank accounts.
- **Updating an Account:** Modify account details such as account type or owner.
- **Account Closing Endpoint:** Users can close their accounts.
- **Read Account by Account number**: Read the account details based on the account number that are active.
- **Read transaction for account:**: Reterive transactions that are made by specific account.

### 💸 Fund Transfer Service
- **Creating an Endpoint to Initiate Fund Transfer:** Transfer funds between accounts.
- **Creating an Endpoint to Get Details of All Fund Transfers:** Retrieve details of all fund transfers made by the account.
- **Creating an Endpoint to Get Details of a Particular Fund Transfer:** Get details of a specific fund transfer.

### 💳 Transaction Service
- **Creating an Endpoint to Get All Transactions Made by an Account:** Retrieve all transactions made by an account.
- **Creating an Endpoint to Get Particular Transaction Details:** Retrieve details of a specific transaction.
- **Make a transaction:** Make transaction such as deposit of amount to a bank account or withdraw money from the account.

---

<h2 align="center">🚀 Getting Started</h2>

To get started with this Spring Boot Microservices Banking Application, follow these steps:

1. Clone the repository to your local machine.
2. Set up and configure the individual microservices (User Service, Account Service, Fund Transfer Service, Transaction Service).
3. Start the microservices in the desired order (Service Registry, API Gateway, User Service, Account Service, Fund Transfer Service, Transaction Service).
4. Explore the API documentation to understand how to make requests to each microservice.

---

<h2 align="center">📖 Documentation</h2>

For detailed API documentation and usage instructions, refer to the individual microservices' README files and documentation within each service.

---

<h2 align="center">🤝 Contribution</h2>

Contributions to this project are welcome! Feel free to open issues, submit pull requests, or provide feedback to enhance the functionality and usability of this banking application.

Let's build a robust and efficient banking system together using Spring Boot microservices!

Happy Banking! 🏦💰
