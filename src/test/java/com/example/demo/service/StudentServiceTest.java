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
    }

    @Test
    void createStudent() {
    }

    @Test
    void createStudent_invalidEmail() {
    }

}