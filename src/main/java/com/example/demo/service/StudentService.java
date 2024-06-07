package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentRepository.save(student);
        return studentRepository.save(student);
    }

    public Student updateStudent(String studentId, Student student) {
        Student existingStudent = getExistingStudent(studentId);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return existingStudent;
    }


    public void deleteStudent(String studentId) {
        Student existingStudent = getExistingStudent(studentId);
        studentRepository.delete(existingStudent);
    }

    private Student getExistingStudent(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("Student not found"));
    }
}
