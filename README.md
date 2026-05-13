# Student Management REST API

A clean, production-style RESTful API built with **Spring Boot** for managing student records. Features a layered architecture, custom exception handling, and structured JSON error responses.

---

## Tech Stack

| Technology  | Details           |
|-------------|-------------------|
| Language    | Java 24           |
| Framework   | Spring Boot 4.0.6 |
| Module      | Spring Web        |
| Build Tool  | Maven             |

---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/
            └── arpan/
                └── student_manage_api/
                    ├── controller/
                    │   └── StudentController.java        # Handles incoming HTTP requests & sends responses
                    ├── model/
                    │   └── Student.java                  # Data model: id, name, age, email
                    ├── service/
                    │   └── StudentService.java           # Core business logic & data processing
                    ├── exception/
                    │   ├── GlobalExceptionHandler.java   # Catches all exceptions globally via @ControllerAdvice
                    │   ├── StudentNotFoundException.java  # Custom exception for missing students
                    │   └── ErrorResponse.java            # Structured JSON error response model
                    └── StudentManageApiApplication.java  # Application entry point
```

---

## API Endpoints

| Method   | Endpoint              | Description             | Response                   |
|----------|-----------------------|-------------------------|----------------------------|
| `GET`    | `/api/students`       | Fetch all students      | `200 OK`                   |
| `GET`    | `/api/students/{id}`  | Fetch student by ID     | `200 OK` / `404 Not Found` |
| `POST`   | `/api/students`       | Create a new student    | `201 Created`              |
| `PUT`    | `/api/students/{id}`  | Update existing student | `200 OK`                   |
| `DELETE` | `/api/students/{id}`  | Delete a student        | `200 OK`                   |

---

---

## Error Handling

Instead of a generic error page, all failures return a clean, structured JSON response:

```json
{
  "status": 404,
  "message": "Student not found with id: 99"
}
```

This is handled globally by `GlobalExceptionHandler` using `@ControllerAdvice`, so no controller-level try/catch is needed.

---

## Getting Started

**1. Clone the repository**
```bash
git clone https://github.com/ArpanC6/student-management-api.git
```

**2. Navigate to the project folder**
```bash
cd student-manage-api
```

**3. Run the application**
```bash
./mvnw spring-boot:run
```

**4. API is available at:**
```
http://localhost:8080
```

---

## Sample Requests & Responses

### GET /api/students — Fetch all students

```json
[
  {
    "id": 1,
    "name": "Arpan Kumar",
    "age": 22,
    "email": "arpan.updated@gmail.com"
  },
  {
    "id": 2,
    "name": "Rahul",
    "age": 22,
    "email": "rahul@gmail.com"
  }
]
```

### GET /api/students/1 — Fetch student by ID

```json
{
  "id": 1,
  "name": "Arpan Kumar",
  "age": 22,
  "email": "arpan.updated@gmail.com"
}
```

### POST /api/students — Create a new student

**Request Body:**
```json
{
  "id": 5,
  "name": "Subhas",
  "age": 24,
  "email": "subhas@gmail.com"
}
```

**Response:** `201 Created`

### GET /api/students/99 — Student not found

```json
{
  "status": 404,
  "message": "Student not found with id: 99"
}
```

---