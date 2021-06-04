package com.example.demovscodespring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToMany
  @JoinTable(name = "student_enrolled", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
  private Set<Student> enrolledStudents = new HashSet<>();

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  private Teacher teacher;

  private String name;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Set<Student> getEnrolledStudents() {
    return enrolledStudents;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void enrollStudent(Student student) {
    enrolledStudents.add(student);
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
}
