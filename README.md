# Book_For_Rent

# Book Rental System

## Introduction

The Book Rental System is a web application designed to manage the rental of books to users. It provides functionality for user registration, authentication, and various operations related to managing books and rentals.

## Features

- **User Management**: Users can register and authenticate to access the system.
- **Admin Panel**: Admins have access to additional features like managing users and adding books to the library.
- **Book Management**: Users can check the availability of books, rent them, and submit them after reading.
- **JWT Authentication**: Uses JSON Web Tokens (JWT) for secure authentication and authorization of users.
- **Spring Security**: Implements Spring Security to manage authentication and authorization.
- **RESTful API**: Provides a set of RESTful endpoints for interacting with the system programmatically.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- MySQL (or any other database of choice)
- Maven

## Setup

1. Clone the repository to your local machine.
2. Configure the database settings in `application.properties`.
3. Run the application using Maven: `mvn spring-boot:run`.
4. Access the application at `http://localhost:8080`.

## Endpoints

- **User Management Endpoints**:
  - `POST /bookrent/registerUser`: Register a new user.
  - `POST /bookrent/authenticate`: Authenticate user credentials and generate a JWT token.
  
- **Admin Endpoints**:
  - `GET /bookrent/getUserById`: Retrieve user details by user ID (requires ADMIN role).
  - `DELETE /bookrent/deleteUser`: Delete a user (requires ADMIN role).
  - `DELETE /bookrent/deleteUserById`: Delete a user by user ID (requires ADMIN role).
  - `POST /bookrent/addBook`: Add a new book to the library (requires ADMIN role).
  
- **User Endpoints**:
  - `GET /bookrent/isBookAvailable`: Check if a book is available for rent (requires USER role).
  - `POST /bookrent/takeBook`: Rent a book (requires USER role).
  - `PUT /bookrent/bookSubmission`: Submit a rented book (requires USER role).
  - `GET /bookrent/getAllBooks`: Get a list of all available books (accessible to both USER and ADMIN roles).

These endpoints provide the necessary functionality for user registration, authentication, book management, and rental operations. Ensure proper authentication and authorization when accessing protected endpoints.

## Author

[Kishore Thalisetty]

## License

This project is licensed under the [MIT License](LICENSE).
