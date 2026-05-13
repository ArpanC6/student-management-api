package com.arpan.student_manage_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
        public ResponseEntity<?> handlerStudentNotFound(StudentNotFoundException ex) {
            return ResponseEntity.status(404)
                    .body(new ErrorResponse(404, ex.getMessage()));
        }
    }