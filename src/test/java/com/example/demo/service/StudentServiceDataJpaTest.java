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
        Student student = Student.builder().firstName("John").lastName("Doe").email("john.doe@gmail.com").build();
        Student createdStudent = studentService.createStudent(student);
        assertNotNull(createdStudent);
        assertNotNull(createdStudent.getId());
        assertEquals(student.getFirstName(), createdStudent.getFirstName());
        assertEquals(student.getLastName(), createdStudent.getLastName());
    }

    @Test
    void getStudents() {
        createStudent();
        assertEquals(1, studentService.getStudents().size());
    }

    @Test
    void updateStudent() {
        createStudent();
        Student student = studentService.getStudents().get(0);
        student.setFirstName("James");
        Student updatedStudent= studentService.updateStudent(student);
        assertEquals("James", updatedStudent.getFirstName());
    }

    @Test
    void deleteStudent() {
        createStudent();
        Student student = studentService.getStudents().get(0);
        studentService.deleteStudent(student.getId());
        assertEquals(0, studentService.getStudents().size());
    }
}