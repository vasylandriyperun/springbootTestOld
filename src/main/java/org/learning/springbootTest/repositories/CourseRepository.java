package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
