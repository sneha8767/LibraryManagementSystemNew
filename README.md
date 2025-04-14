# Library Management System

## Overview
The Library Management System is a web application aimed at automating and simplifying the day-to-day operations of a library. With a user-friendly interface, it helps track book availability, issue/return of books, and book management. The system offers separate roles for the **Admin** and **User**, ensuring efficient book management and usage.

### Key Features:
- **User Registration & Login**: Users can register and log in to manage their borrowing activities.
- **Admin Features**: Admins have access to a dashboard where they can:
  - Add, update, and remove books.
  - Manage users and view issued book history.
  - Monitor the status of borrowed and returned books.
- **Book Issue & Return**: Users can issue books for a certain period and return them once done.
- **Book Search**: Users can search books by title, author, or genre.
- **Notifications**: Users are notified about overdue books and return deadlines.
- **User History**: Track all borrowed books and their return status.

## Tech Stack
- **Backend**: 
  - **Java** (Servlets and JSP)
  - **MySQL** (Database)
- **Frontend**: 
  - **HTML**, **CSS**, **JavaScript**
- **Web Server**: Apache Tomcat (for deployment)
- **Additional Tools**: 
  - **JDBC** for database connectivity
  - **Servlets** for request/response handling

## Database Schema
The system uses **MySQL** for persistent storage. The following tables are used:
1. **Users**: Stores user information such as name, email, password, and role (Admin/User).
2. **Books**: Stores book details such as title, author, genre, publication date, and availability.
3. **IssuedBooks**: Tracks the books issued to users, along with issue and return dates.
4. **Transactions**: Logs all user transactions, including book issues and returns.

## Installation

### Prerequisites
- JDK (Java Development Kit) installed on your machine
- MySQL Database server
- Apache Tomcat for running the web application

### Steps to Install:
1. **Clone the repository**:
   ```bash
   git clone https://github.com/dnyaneshwar910/LibraryManagementSystem.git
