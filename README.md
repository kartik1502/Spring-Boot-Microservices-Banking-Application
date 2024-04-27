<h1 align="center">🌟 Spring-Boot-Microservices-Banking-Application 🌟</h1>

<h2 align="center">📋 Table of Contents</h2>

- [🔍 About](#-about)
- [🏛️ Architecture](#-architecture)
- [🚀 Microservices](#-microservices)
  - [👤 User Service](#-user-service)
  - [💼 Account Service](#-account-service)
  - [💸 Fund Transfer Service](#-fund-transfer-service)
  - [💳 Transaction Service](#-transaction-service)
- [🚀 Getting Started](#-getting-started)
- [📖 Documentation](#-documentation)
- [🤝 Contribution](#-contribution)

## 🔍 About
<p>
    The Banking Application is built using a microservices architecture, incorporating the Spring Boot framework along with other Spring technologies such as Spring Data JPA, Spring Cloud, and Spring Security, alongside tools like Maven for dependency management. These technologies play a crucial role in establishing essential components like Service Registry, API Gateway, and more.<br><br>
    Moreover, they enable us to develop independent microservices such as the user service for user management, the account service for account generation and other related functionalities, the fund transfer service for various transfer operations, and the transaction service for viewing transactions and facilitating withdrawals and deposits. These technologies not only streamline development but also enhance scalability and maintainability, ensuring a robust and efficient banking system.
</p>

## 🏛️ Architecture

- **Service Registry:** The microservices uses the discovery service for service registration and service discovery, this helps the microservices to discovery and communicate with other services, without needing to hardcode the endpoints while communicating with other microservices.

- **API Gateway:** This microservices uses the API gateway to centralize the API endpoint, where all the endpoints have common entry point to all the endpoints. The API Gateway also facilitates the Security inclusion where the Authorization and Authentication for the Application.

- **Database per Microservice:** Each of the microservice have there own dedicated database. Here for this application for all the microservices we are incorparating the MySQL database. This helps us to isolate each of the services from each other which facilitates each services to have their own data schemas and scale each of the database when required.


<h2>🚀 Microservices</h2>

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

<h2>🚀 Getting Started</h2>

To get started with this Spring Boot Microservices Banking Application, follow these steps:

1. Clone the repository to your local machine.
2. Set up and configure the individual microservices (User Service, Account Service, Fund Transfer Service, Transaction Service).
3. Start the microservices in the desired order (Service Registry, API Gateway, User Service, Account Service, Fund Transfer Service, Transaction Service).
4. Explore the API documentation to understand how to make requests to each microservice.

---

<h2>📖 Documentation</h2>
<h3>📖 API Documentation</h3>

For detailed API documentation and usage instructions

You can access the comprehensive [API Documentation](https://app.theneo.io/student/spring-boot-microservices-banking-application) in one place for a unified view of the entire banking application.

<h3>📚 Java Documentation (JavaDocs)</h3>

The JavaDocs for all services together are available online for your convenience:

- **Java Documentation:** [Java Documentation](https://kartik1502.github.io/Spring-Boot-Microservices-Banking-Application/)

You can click on the link above to access the combined JavaDocs for all microservices. These JavaDocs provide detailed information about the classes, methods, and variables used in each microservice, making it easier for developers to understand and work with the codebase across all services.

---

<h2>🤝 Contribution</h2>

Contributions to this project are welcome! Feel free to open issues, submit pull requests, or provide feedback to enhance the functionality and usability of this banking application.

Let's build a robust and efficient banking system together using Spring Boot microservices!

Happy Banking! 🏦💰

<h2>📞 Contact Information</h2>

If you have any questions, feedback, or need assistance with this project, please feel free to reach out to me:

[![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/6361921186)
[![GMAIL](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:kartikkulkarni1411@gmail.com)

We appreciate your interest in our project and look forward to hearing from you. Happy coding!
