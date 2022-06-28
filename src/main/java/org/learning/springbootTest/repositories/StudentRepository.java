package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> getAll();

}
