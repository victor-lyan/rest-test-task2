package com.example.resttesttask2.repository;

import com.example.resttesttask2.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    @Transactional(readOnly = true)
    Student findByFirstNameOrLastName(String firstName, String lastName);
}
