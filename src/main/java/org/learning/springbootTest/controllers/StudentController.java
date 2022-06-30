package org.learning.springbootTest.controllers;

import org.learning.springbootTest.dto.ExceptionResponse;
import org.learning.springbootTest.exception.WrongIdProvidedException;
import org.learning.springbootTest.model.Student;
import org.learning.springbootTest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if (name != null && surname != null)
            return studentService.getStudentsWithNameAndSurname(name, surname);
        if (surname != null)
            return studentService.getStudentsWithSurname(surname);
        if (name != null)
            return studentService.getStudentsWithName(name);
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/students/find")
    public List<Student> getStudentsWithSurnameLike(@RequestParam String surnamePart) {
        return studentService.getStudentsWithSurnameLike(surnamePart);
    }

    @ExceptionHandler(WrongIdProvidedException.class)
    public final ResponseEntity<ExceptionResponse> handleWrongIdException(WrongIdProvidedException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
