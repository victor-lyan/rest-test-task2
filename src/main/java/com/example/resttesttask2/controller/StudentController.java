package com.example.resttesttask2.controller;

import com.example.resttesttask2.exception.StudentNotFoundException;
import com.example.resttesttask2.exception.StudentValidationException;
import com.example.resttesttask2.model.Student;
import com.example.resttesttask2.service.StudentService;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{search}")
    public Student findStudent(@PathVariable String search) {
        Student student = studentService.findByFirstNameOrLastName(search);
        if (student == null) {
            throw new StudentNotFoundException();
        }
        
        return student;
    }
    
    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            throw new StudentValidationException(result.getAllErrors().stream()
                .map(x -> x.getDefaultMessage()).collect(Collectors.joining(", ")));
        }
        studentService.saveStudent(student);
        
        return student;
    }
}
