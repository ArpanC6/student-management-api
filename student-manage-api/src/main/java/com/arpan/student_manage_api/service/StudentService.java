package com.arpan.student_manage_api.service;


import com.arpan.student_manage_api.exception.StudentNotFoundException;
import com.arpan.student_manage_api.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "Arpan", 21, "arpan@gmail.com"));
        students.add(new Student(2, "Rahul", 22, "rahul@gmail.com"));
        students.add(new Student(3, "Ram", 23, "ram@gmail.com"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

}
