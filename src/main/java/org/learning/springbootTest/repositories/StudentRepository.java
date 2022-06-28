package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> getAll();

    Optional<Student> findById(int id);

}
