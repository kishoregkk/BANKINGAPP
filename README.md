# BANKINGAPP
# Banking App REST API using Spring Boot

Welcome to the Banking App REST API! This application provides a set of endpoints to manage banking operations for account management.

## Technologies Used
- Java 8+
- Spring Boot
- Spring Data JPA
- MySQL (or any other database)
- Maven
- Spring web

## Getting Started
To get started with the Banking App REST API, follow these steps:

### Prerequisites
- Java 8 or higher installed on your machine
- Maven installed on your machine
- MySQL (or any other database) installed and running

### Installation
1. Clone the repository:
2. Navigate to the project directory
3. Build the project using Maven
4. Run the application:


The application will start on `http://localhost:8080`.

### Configuration
- Database configuration can be found in `src/main/resources/application.properties`. Modify the configuration according to your database setup.
- You may need to create the database schema manually or configure Spring Boot to create it automatically by setting the `spring.jpa.hibernate.ddl-auto` property in `application.properties`.

## API Endpoints
The following endpoints are available in the API:

### Accounts
- **GET /bank/all**: Retrieve all accounts.
- **GET /bank/{id}**: Retrieve an account by ID.
- **POST /bank/create**: Create a new account.
- **DELETE /bank/delete/{id}**: Delete an account.

## Deposit and Withdraw Amount
- **PUT/bank/withdraw/{id}**: Withdraw Amount from account.
- **PUT/bank/deposit/{id}**: Deposit Amount into a specific account.

## Authentication and Authorization
- This example does not include authentication and authorization. Implement appropriate mechanisms as per your requirements, such as OAuth2, JWT, etc.

## Contributor
- G K Kishore




