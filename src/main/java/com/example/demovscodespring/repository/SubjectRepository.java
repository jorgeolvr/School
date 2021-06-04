package com.example.demovscodespring.repository;

import com.example.demovscodespring.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
