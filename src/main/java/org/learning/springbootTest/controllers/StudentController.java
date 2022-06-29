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

    @GetMapping(path = "/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/students/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PostMapping(path = "/students/new")
    public void addStudent(@RequestBody Student student) {
        studentService.createAndSaveStudent(student);
    }

    @PutMapping(path = "/students/{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @GetMapping(path = "/students")
    public List<Student> getStudentByName(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String surname) {
        if (name == null) {
            return studentService.getAllStudents();
        } else if (surname == null) {
            return studentService.getStudentsWithName(name);
        } else {
            return studentService.getStudentsWithNameAndSurname(name,surname);
        }

    }

    @GetMapping(path = "/students/find")
    public List<Student> getStudentsWithSurnameLike(@RequestParam String surnamePart){
        return studentService.getStudentsWithSurnameLike(surnamePart);
    }

}
