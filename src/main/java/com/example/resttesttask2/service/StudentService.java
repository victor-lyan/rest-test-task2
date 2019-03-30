package com.example.resttesttask2.service;

import com.example.resttesttask2.model.Student;
import com.example.resttesttask2.repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findByFirstNameOrLastName(String search) {
        return studentRepository.findByFirstNameOrLastName(search, search);
    }
    
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
