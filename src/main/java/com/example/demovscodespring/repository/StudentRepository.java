package com.example.demovscodespring.repository;

import com.example.demovscodespring.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository recebe na primeira posição o tipo (Student) da classe que irar
 * mapear, na segunda posição é o tipo da chave primária da entidade, que no
 * caso é Long.
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
