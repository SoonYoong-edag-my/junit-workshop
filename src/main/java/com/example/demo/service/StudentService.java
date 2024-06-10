package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.ValidateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        validateStudent(student);
        student.setId(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student updateStudent(Student student) {
        validateStudent(student);

        Student existingStudent = getExistingStudent(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return existingStudent;
    }

    public void deleteStudent(String studentId) {
        Student existingStudent = getExistingStudent(studentId);
        studentRepository.delete(existingStudent);
    }

    private Student getExistingStudent(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    private static void validateStudent(Student student) {
        if (!ValidateUtil.isValidName(student.getFirstName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid first name");
        }

        if (!ValidateUtil.isValidName(student.getFirstName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid last name");
        }

        if (!ValidateUtil.isValidEmail(student.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email");
        }
    }
}
