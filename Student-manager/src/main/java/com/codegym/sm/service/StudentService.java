package com.codegym.sm.service;

import com.codegym.sm.model.Student;

import java.util.List;

public interface StudentService  {
    List<Student>fillAll();
    Student findById(Long id);
    void save(Student student);
    void remove(Long id);

}
