# Student Management REST API

A RESTful API built with Spring Boot for managing student data,
featuring proper MVC architecture and global exception handling.

## Tech Stack

- Java 24
- Spring Boot 4.0.6
- Spring Web (REST API)
- Maven

```
src/
└── main/
    └── java/
        └── com/
            └── arpan/
                └── student_manage_api/
                    ├── controller/
                    │   └── StudentController.java       # Handles HTTP requests
                    ├── model/
                    │   └── Student.java                 # Data model (id, name, age, email)
                    ├── service/
                    │   └── StudentService.java          # Business logic
                    ├── exception/
                    │   ├── GlobalExceptionHandler.java  # Catches all exceptions globally
                    │   ├── StudentNotFoundException.java # Custom exception
                    │   └── ErrorResponse.java           # Clean JSON error response
                    └── StudentManageApiApplication.java  # Entry point
```

## API Endpoints

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| GET | /api/students | Get all students | 200 OK |
| GET | /api/students/{id} | Get student by ID | 200 OK / 404 Not Found |

## Error Handling

Instead of returning a generic error page, invalid requests return
a clean JSON error response.

```json
{
  "status": 404,
  "message": "Student not found with id: 99"
}
```

## Architecture

```
HTTP Request
     |
     v
StudentController      (Receives request, sends response)
     |
     v
StudentService         (Business logic, data processing)
     |
     v
Student Model          (Data: id, name, age, email)
     |
     v (if error)
GlobalExceptionHandler (Catches exception, returns clean JSON)
```

## How to Run

1. Clone the repository

git clone https://github.com/ArpanC6/student-management-api.git

2. Navigate to project folder

cd student-management-api/student-manage-api

3. Run the application

./mvnw spring-boot:run

4. API will start at http://localhost:8080

## Sample Response

GET /api/students

```json
[
  { "id": 1, "name": "Arpan", "age": 21, "email": "arpan@gmail.com" },
  { "id": 2, "name": "Rahul", "age": 22, "email": "rahul@gmail.com" },
  { "id": 3, "name": "Ram",   "age": 23, "email": "ram@gmail.com"   }
]
```

GET /api/students/1

```json
{
  "id": 1,
  "name": "Arpan",
  "age": 21,
  "email": "arpan@gmail.com"
}
```