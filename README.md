# Game Matchmaking System

This repository contains the backend implementation of an online multiplayer game matchmaking platform developed using Spring Boot and MySQL.

The backend is responsible for managing core game operations such as player management,match handling,ranking and MMR tracking,loadout and weapon configuration and performance analysis.Therefore it follows a layered architecture to ensure separation of concerns,maintainability and scalability.

---

## Project Overview

The backend is designed to expose RESTful APIs that allow interaction with the underlying relational database. It handles all business logic, data validation, and request processing required to support a game matchmaking environment.

The system integrates with a MySQL database that stores structured game data and enforces data integrity through relational constraints.

---

## Technologies Used

- Java  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- RESTful API Architecture  

---

## Backend Architecture

The application follows a layered architecture consisting of:

- **Entity Layer**: Represents database tables using JPA entity classes  
- **Repository Layer**: Provides data access using Spring Data JPA  
- **Service Layer**: Contains business logic and application rules  
- **Controller Layer**: Exposes REST API endpoints  
- **Exception Layer**: Handles errors and provides consistent API responses  
- **Analysis Layer**: Performs player performance analysis based on match history  

This structure improves code readability,modularity and ease of maintenance.

---

## Features

- Player registration and management  
- Match creation and tracking  
- Player ranking and MMR system  
- Weapon and loadout management  
- Match performance and statistics tracking  
- Player performance analysis  
- Centralized exception handling  

---

## Database Integration

The backend is integrated with a MySQL relational database that manages all persistent data.  

---

## How to Run

1. Configure the MySQL database connection
2. Ensure the database schema is created and populated  
3. Run the Spring Boot application  
4. Access REST endpoints using tools such as Postman  

---

## Notes

This backend project is part of an academic coursework and demonstrates the practical application of backend development concepts,object oriented programming principles and also relational database integration.
