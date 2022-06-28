package org.learning.springbootTest.controllers;

import org.learning.springbootTest.model.Student;
import org.learning.springbootTest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }
}
