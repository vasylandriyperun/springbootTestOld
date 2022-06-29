package org.learning.springbootTest.services;

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
            throw new RuntimeException();
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
}
