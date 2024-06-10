package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/ping")
    public String ping() {
        log.info("ping received");
        return "pong";
    }

    @GetMapping
    @Operation(summary = "Get list of students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    @Operation(summary = "Create new student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update student")
    public Student updateStudent(@PathVariable String id, @Valid @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping
    @Operation(summary = "Delete student")
    public void deleteStudent(String id) {
        studentService.deleteStudent(id);
    }

}
