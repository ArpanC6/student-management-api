package com.arpan.student_manage_api.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int id) {
        super("Student not found with id: " + id);
    }
}