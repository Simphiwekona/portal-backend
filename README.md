# Employee Management App - Backend

## Overview

Welcome to the Employee Management App backend! This application serves as the server-side component responsible for handling data storage, retrieval, and management. The backend is developed in Java using the Spring Boot framework.

## Features

- **Data Capture:** Receives and processes employee data sent from the frontend (React) application.

- **Data Storage:** Utilizes Firestore for persistent storage and maintains an in-memory storage for quick data access.

- **Java 11:** The backend is developed using Java 11, taking advantage of its features and improvements.

- **Dependencies:**
    - **Spring Boot (v2.7.17):** The backend is built using the Spring Boot framework, providing a robust and scalable foundation.
    - **Lombok:** Streamlines Java code by reducing boilerplate code, enhancing productivity.
    - **Firebase SDK:** Connects the backend to Firestore, enabling seamless communication with the database.

- **Integrated Development Environment (IDE):** This project is developed using IntelliJ IDEA.

## Prerequisites

- **Java 11:** Ensure that Java 11 is installed on your machine. You can download it [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

- **IntelliJ IDEA:** The recommended IDE for this project. You can download it [here](https://www.jetbrains.com/idea/download/).

## Getting Started

To run the backend locally, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/Simphiwekona/portal-backend.git
2. Open the project in IntelliJ IDEA.
3. Run the application.
4. The backend should now be running on http://localhost:8080.

# Usage
1. ## Data Capture from frontend:
   - The backend is designed to receive employee data from the associated frontend (React) application via API calls.
2. ## Data Storage:
    - Employee data is stored in Firestore for persistent storage.
    - In-memory storage is used for quick access to data.
# Dependencies
    - Java 11: The backend is developed using Java 11.
    - Spring Boot (v2.7.17): A powerful and flexible framework for building Java-based enterprise applications.
    - Lombok: A Java library that automatically plugs into your editor and builds tools, spicing up your java.
    - Firebase SDK: Provides the tools needed to integrate the backend with Firestore.