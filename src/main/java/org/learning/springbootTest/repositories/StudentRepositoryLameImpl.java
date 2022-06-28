package org.learning.springbootTest.repositories;

import org.learning.springbootTest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryLameImpl implements StudentRepository{

    static List<Student> studentList;


    static {
        studentList  = new ArrayList<>();
        Student studentAnton = new Student(1, "Anton", "Baton");
        Student studentMasha = new Student(2, "Masha", "Medved");
        Student studentPasha = new Student(3, "Pasha", "Technik");
        studentList.add(studentAnton);
        studentList.add(studentPasha);
        studentList.add(studentMasha);
    }

    @Override
        public List<Student> getAll() {
            return studentList;
    }
}
