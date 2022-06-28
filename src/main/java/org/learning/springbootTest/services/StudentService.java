package org.learning.springbootTest.services;

import org.learning.springbootTest.model.Student;
import org.learning.springbootTest.repositories.StudentRepositoryLameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepositoryLameImpl repository;

    public List<Student> getAllStudents() {
        return repository.getAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }
}
