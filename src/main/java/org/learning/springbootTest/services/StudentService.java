package org.learning.springbootTest.services;

import org.learning.springbootTest.model.Student;
import org.learning.springbootTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.getAll();
    }
}
