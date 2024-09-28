# 🛒 E-Commerce Payment System - Pix Integration

## 📖 Table of Contents

- [📄 Description](#-description)
- [💡 What is Pix?](#-what-is-pix)
- [✨ Features](#-features)
- [🛠 Technologies Used](#-technologies-used)
- [📋 Prerequisites](#-prerequisites)
- [⚙️ Setup](#️-setup)
- [🔌 API Endpoints](#-api-endpoints)
  - [🔑 Authentication](#-authentication)
  - [💸 Pix Operations](#-pix-operations)
- [📧 Email Verification](#-email-verification)
- [🔐 Security](#-security)
- [📜 License](#license)
- [🤝 Contributing](#contributing)
- [🙏 Acknowledgments](#acknowledgments)

## 📄 Description

This project is an E-Commerce Payment System that integrates the Pix payment method. It allows users to create and manage Pix transactions efficiently. The system is built using Java and Spring Boot, leveraging the EfiPay SDK for handling Pix operations.

## 💡 What is Pix?

Pix is a real-time payment system developed by the Central Bank of Brazil. It allows users to make instant payments 24/7, using various methods such as QR codes, phone numbers, and email addresses. Pix is designed to be fast, secure, and cost-effective, making it a popular choice for both consumers and businesses in Brazil.

## ✨ Features

- 🔐 User authentication and authorization using **JWT (JSON Web Token)**
- 🔒 Password encryption for secure storage
- 📧 Email verification after user registration
- 💵 Create Pix charges
- 📱 Generate QR codes for payments
- 🧪 Support for sandbox and production environments
- 🛠️ Debug mode for development

## 🛠 Technologies Used

- **☕ Java**: Programming language for backend development.
- **🌱 Spring Boot**: Framework for building the backend RESTful API.
- **🧰 EfiPay SDK**: Library for interacting with the Pix payment system.
- **🔑 JWT**: Token-based authentication.
- **🔐 BCrypt**: Password hashing for secure storage.
- **📧 SMTP**: For sending email verifications.
- **📊 JSON**: Data format for API requests and responses.

## 📋 Prerequisites

- 🔧 JDK 11 or higher
- 🐘 Maven
- 📝 An active EfiPay account with client credentials

## ⚙️ Setup

1. **📥 Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/e-commerce-payment-system.git
    ```
2. **📂 Navigate to the project directory:**
    ```bash
    cd e-commerce-payment-system
    ```
3. **📝 Add your credentials:**
    Create a `credentials.json` file in the `src/main/resources` directory with the following structure:
    ```bash
    {
        "client_id": "YOUR_CLIENT_ID",
        "client_secret": "YOUR_CLIENT_SECRET",
        "certificate": "./certs/your_certificate.p12",
        "sandbox": true,
        "debug": false
    }
    ```
4. **🔨 Build the project:**

    Use Maven to build the project:
    ```bash
    mvn clean install
    ```
5. **▶️ Run the application:**

    ```bash
    mvn spring-boot:run
    ```
6. **🌐 Access the API:**
    Open your browser or a tool like Postman and navigate to:
    ```bash
    http://localhost:8080/api/auth/login
    ```
    Use the following JSON body to log in:
    ```bash
    {
        "email": "your_email@example.com",
        "password": "your_password"
    }
    ```

## 🔌 API Endpoints

### **🔑 Authentication**
- POST `/api/auth/login`: Authenticates the user and returns a JWT token.
- POST `/api/auth/register`: Registers a new user with encrypted password and sends an email verification link.

### **💸 Pix Operations**
- POST `/api/pix`: Creates a Pix charge with the specified parameters.

## **📧 Email Verification**
- After a user registers through `/api/auth/register`, an email is sent with a verification link.
- The user must click the link in the email to confirm their account and complete the registration process.
- GET `/api/auth/verify?code=your_verification_token`: This endpoint verifies the user's email using the token received in the email.

## 🔐 Security

- **JWT (JSON Web Token)** is used for secure user authentication, ensuring that only authenticated users can access certain endpoints.
- **BCrypt password hashing** is used to securely store user passwords, adding a layer of protection against unauthorized access.
- **Email verification** ensures that only valid email addresses can be used for user registration, enhancing security and preventing spam accounts.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

## Contributing

Contributions are welcome! Please create a pull request or open an issue to discuss improvements.

## Acknowledgments

- Thanks to the EfiPay team for providing the Pix SDK.
