package com.example.demovscodespring.controller;

import java.util.List;

import com.example.demovscodespring.entity.Student;
import com.example.demovscodespring.entity.Subject;
import com.example.demovscodespring.entity.Teacher;
import com.example.demovscodespring.repository.StudentRepository;
import com.example.demovscodespring.repository.SubjectRepository;
import com.example.demovscodespring.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
  @Autowired
  SubjectRepository subjectRepository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  TeacherRepository teacherRepository;

  @GetMapping
  public List<Subject> getSubjects() {
    return subjectRepository.findAll();
  }

  @PostMapping
  public Subject createSubjects(@RequestBody Subject subject) {
    return subjectRepository.save(subject);
  }

  @PutMapping("/{subjectId}/students/{studentId}")
  public Subject enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
    Subject subject = subjectRepository.findById(subjectId).get();
    Student student = studentRepository.findById(studentId).get();

    subject.enrollStudent(student);

    return subjectRepository.save(subject);
  }

  @PutMapping("/{subjectId}/teacher/{teacherId}")
  Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
    Subject subject = subjectRepository.findById(subjectId).get();
    Teacher teacher = teacherRepository.findById(teacherId).get();
    subject.setTeacher(teacher);
    return subjectRepository.save(subject);
  }

}
