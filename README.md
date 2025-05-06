# 🧩 Spring Boot REST API with JPA and H2

This project is a simple REST API developed with **Spring Boot**, using **Spring Data JPA** and an **in-memory H2 database**. It is designed as a technical interview test, showcasing good practices in architecture, clean design, and extensibility.

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA (Hibernate)
- H2 Database
- Swagger (OpenAPI)
- JUnit 5 / Mockito (for testing)

---

## 📦 Features

- Full CRUD for `User` entity
- Layered architecture: `Controller`, `Service`, `Repository`, `Model`
- Persistence with JPA/Hibernate
- In-memory H2 database (no external configuration)
- Interactive documentation with Swagger UI
- Global exception handling with `@ControllerAdvice`
- Basic unit and integration tests

---

## 🔧 Quick Setup

### 1. Clone the project
```bash
git clone https://github.com/youruser/springboot-h2-crud.git
cd springboot-h2-crud
```

### 2. Run with Maven
```bash
./mvnw spring-boot:run
```

---

## 🧪 Endpoints

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| GET    | `/users`         | Get all users             |
| GET    | `/users/{id}`    | Get user by ID            |
| POST   | `/users`         | Create a new user         |
| PUT    | `/users/{id}`    | Update a user             |
| DELETE | `/users/{id}`    | Delete a user             |

---

## 📚 Swagger UI

Available at:  
```
http://localhost:8080/swagger-ui.html
```

---

## 💻 H2 Console (optional)

Available at:  
```
http://localhost:8080/h2-console
```

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User:** `sa`
- **Password:** _(empty)_

---

## ✅ JSON Example for POST and PUT
```json
{
  "name": "Juan Pérez",
  "email": "juan@example.com"
}
```

---

## 🧠 Technical Recommendations

- This project can easily scale to an architecture using PostgreSQL/MySQL.
- It is recommended to add Spring Security if authentication is required.
- The pattern used allows for easy and maintainable addition of more entities.

---

## 📌 Author

Gerard Contreras  
Backend Software Engineer Candidate  
Specialized in C#, Java, Security, and Best Practices
