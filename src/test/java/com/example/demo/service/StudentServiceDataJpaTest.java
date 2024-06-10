package com.example.demo.service;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@Import(StudentService.class)
class StudentServiceDataJpaTest {

    @Autowired
    StudentService studentService;

    @Test
    void createStudent() {
    }

    @Test
    void getStudents() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudent() {
    }
}