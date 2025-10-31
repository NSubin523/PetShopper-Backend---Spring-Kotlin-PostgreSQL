# 🐾 PetShopper Backend

A robust and scalable backend service for the PetShopper application, built with **Kotlin** and the **Spring Boot** framework. It leverages a modern architecture powered by **PostgreSQL** for persistence, **Redis** for caching/session management, and **Docker** for containerization.

## ✨ Features

* **RESTful API:** Clean, well-defined endpoints for seamless client-server interaction.
* **Secure Authentication:** Utilizes **Spring Security** and **JSON Web Tokens (JWT)** for secure, stateless authentication and authorization.
* **Event-Driven Architecture:** Implements **Event Listeners and Providers** to decouple components and handle asynchronous tasks efficiently.
* **Containerized Environment:** Ready-to-go setup using **Docker** and `docker-compose` for easy local development and deployment.
* **Data Integrity:** Managed database migrations using **Flyway**.
* **Validation:** Robust input validation using `spring-boot-starter-validation`.
* **Health Monitoring:** Includes **Spring Boot Actuator** for production-ready monitoring and management.

---

## 🛠️ Tech Stack & Architecture

### **Core Technologies**

| Technology | Description |
| :--- | :--- |
| **Kotlin** | Modern, concise, and expressive language for the entire backend. |
| **Spring Boot** | Framework for rapid, production-ready Spring applications. |
| **PostgreSQL** | Reliable, open-source object-relational database. |
| **Redis** | High-performance in-memory data store, used for caching and session data. |
| **Docker** | Containerization for consistent development, staging, and production environments. |

### **Project Architecture (Layered MVC)**

The backend follows a strict **Model-View-Controller (MVC)** pattern with a distinct, clean layering for separation of concerns and maintainability.

> **Data Flow:**
>
> `Controller` $\rightarrow$ `Service Layer` $\rightarrow$ `Repository` $\rightarrow$ `Database`

The detailed data flow from persistence to presentation is:

1.  **`Model`** (JPA Entities)
2.  **`DTO`** (Data Transfer Objects for external communication)
3.  **`Mappers`** (To convert between `Model` and `DTO`)
4.  **`Repository`** (Spring Data JPA interfaces)
5.  **`RepoImpl`** (Custom repository logic, if needed)
6.  **`Service Layer`** (Core business logic interfaces)
7.  **`ServiceImpl`** (Implementation of business logic)
8.  **`Controllers`** (Handle incoming HTTP requests and responses)

---

## 🚀 Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### **Prerequisites**

You will need the following installed on your system:

* **Java Development Kit (JDK) 17+**
* **Docker** and **Docker Compose**
* **Maven** (to build the Spring Boot application)

### **Installation & Setup**

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YourUsername/petshopper-backend.git](https://github.com/YourUsername/petshopper-backend.git)
    cd petshopper-backend
    ```

2.  **Set up the environment:**
    The project uses a `docker-compose.yml` file to manage the PostgreSQL and Redis containers.

    ```bash
    # This will pull images and start the PostgreSQL and Redis services
    docker-compose up -d
    ```

3.  **Configure Application Properties:**
    Ensure your `application.properties` or `application.yml` file has the correct configuration to connect to the Dockerized services (e.g., database connection details, Redis host, JWT secret).

4.  **Build and Run the Application:**
    You can run the application using the Spring Boot Maven plugin:

    ```bash
    # Package the application
    mvn clean package

    # Run the application
    java -jar target/animals-0.0.1-SNAPSHOT.jar
    # (Note: Replace the JAR name if it changes)
    ```

    The application will typically start on `http://localhost:8080`.

---

## 📋 Dependencies

The project is built with a curated set of dependencies for security, stability, and developer experience.

| Group | Artifact | Purpose |
| :--- | :--- | :--- |
| `org.springframework.boot` | `spring-boot-starter-web` | Core web capabilities (REST APIs) |
| `org.springframework.boot` | `spring-boot-starter-data-jpa` | Database access with JPA/Hibernate |
| `org.springframework.boot` | `spring-boot-starter-security` | Security framework, authorization, and authentication |
| `org.springframework.boot` | `spring-boot-starter-validation` | Declarative validation using Bean Validation API |
| `org.springframework.boot` | `spring-boot-starter-actuator` | Production-ready features (health, metrics) |
| `org.postgresql` | `postgresql` | PostgreSQL JDBC Driver |
| `org.flywaydb` | `flyway-core`, `flyway-database-postgresql` | Database migration management |
| `io.jsonwebtoken` | `jjwt-api`, `jjwt-impl`, `jjwt-jackson` | JWT creation and validation |
| `com.fasterxml.jackson.module` | `jackson-module-kotlin` | JSON serialization/deserialization for Kotlin data classes |
| `org.jetbrains.kotlin` | `kotlin-reflect`, `kotlin-stdlib` | Kotlin standard libraries and reflection support |

---
