package org.learning.springbootTest.controllers;

import org.learning.springbootTest.model.Book;
import org.learning.springbootTest.model.Course;
import org.learning.springbootTest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(path = "/courses")
    public List<Course> getAllCourse() {
        return courseService.getAllCourses();
    }

}
