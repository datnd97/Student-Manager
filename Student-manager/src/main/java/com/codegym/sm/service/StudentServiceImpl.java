package com.codegym.sm.service;

import com.codegym.sm.model.Student;
import com.codegym.sm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;
    @Override
    public List<Student> fillAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.remove(id);
    }
}
