package org.learning.springbootTest.services;

import org.learning.springbootTest.model.Course;
import org.learning.springbootTest.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

}
