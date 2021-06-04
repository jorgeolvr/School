package com.example.demovscodespring.repository;

import com.example.demovscodespring.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
