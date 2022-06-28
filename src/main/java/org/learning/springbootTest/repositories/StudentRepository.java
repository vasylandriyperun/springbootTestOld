package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
