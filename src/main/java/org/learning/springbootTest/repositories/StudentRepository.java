package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByNameAndSurname(String name, String surname);

    @Query("SELECT st FROM Student st WHERE st.surname LIKE %?1%")
    List<Student> findBySurnameLike(String surnamePart);
}
