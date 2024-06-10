package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    private StudentService studentService;

    private StudentRepository studentRepository;

    @BeforeAll
    public static void init() {
        // This will be run once before all tests
    }

    @BeforeEach
    public void setup() {
        // This will be run before each test
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void createStudent() {
        Student student = Student.builder().firstName("John").lastName("Doe").email("john.doe@gmail.com").build();
        when(studentRepository.save(any())).thenReturn(student);
        Student createdStudent = studentService.createStudent(student);
        assertNotNull(createdStudent);
        assertNotNull(createdStudent.getId());
        assertEquals(student.getFirstName(), createdStudent.getFirstName());
        assertEquals(student.getLastName(), createdStudent.getLastName());
    }

    @Test
    void createStudent_invalidEmail() {
        Student student = Student.builder().firstName("John").lastName("Doe").email("john.doe.gmail.com").build();
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> studentService.createStudent(student));
        assertTrue(exception.getMessage().contains("Invalid email"));

    }

}