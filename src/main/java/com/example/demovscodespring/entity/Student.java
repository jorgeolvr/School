package com.example.demovscodespring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @JsonIgnore
  @ManyToMany(mappedBy = "enrolledStudents")
  Set<Subject> subjects = new HashSet<>();

  private String name;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public void setName(String name) {
    this.name = name;
  }

}
