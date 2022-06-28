package org.learning.springbootTest.controllers;

import org.learning.springbootTest.model.Student;
import org.learning.springbootTest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(path = "/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/students/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

    @PostMapping(path = "/students/new")
    public void addStudent(@RequestBody Student student) {
        studentService.createAndSaveStudent(student);
    }

}
