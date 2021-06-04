package com.example.demovscodespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demovscodespring.entity.Teacher;

/**
 * JpaRepository recebe na primeira posição o tipo (Contato) da classe que irar
 * mapear, na segunda posição é o tipo da chave primária da entidade, que no
 * caso é Long.
 *
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
