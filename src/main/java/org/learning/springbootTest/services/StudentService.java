package org.learning.springbootTest.services;

import org.learning.springbootTest.exception.WrongIdProvidedException;
import org.learning.springbootTest.model.Student;
import org.learning.springbootTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new WrongIdProvidedException("Wrong Student Id provided. " +
                    "Student with id=" + id + " doesn't exist");
        }
    }

    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }

    public void createAndSaveStudent(Student student) {
        if (student.getId() == null
                || !repository.existsById(student.getId()))
            repository.save(student);
    }

    public void updateStudent(Long id, Student student) {
        Student studentExisting = getStudentById(id);
        studentExisting.setName(student.getName());
        studentExisting.setSurname(student.getSurname());
        repository.save(studentExisting);
    }

    public List<Student> getStudentsWithName(String name) {
        return repository.findByName(name);
    }

    public List<Student> getStudentsWithSurname(String surname) {
        return repository.findBySurname(surname);
    }

    public List<Student> getStudentsWithNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    public List<Student> getStudentsWithSurnameLike(String surnamePart) {
        return repository.findBySurnameLike(surnamePart);
    }
}
