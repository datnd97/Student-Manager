package com.codegym.sm.controller;

import com.codegym.sm.model.Student;
import com.codegym.sm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
@Autowired
    public StudentService studentService;
    @GetMapping("/create-student")
    public ModelAndView show() {
        ModelAndView modelAndView =new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        return modelAndView;
    }
    @PostMapping("/create-student")
    public ModelAndView save(@ModelAttribute("student")Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("message","New customer created successfly");
        return modelAndView;
    }
    @GetMapping("/list-students")
    public ModelAndView listStudent() {
        List<Student> students = studentService.fillAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("students",students);
        return modelAndView;
    }
    @GetMapping("/edit-students/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if(student !=null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("student",student);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView  = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("student",student);
        modelAndView.addObject("message","Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-students/{id}")
    public ModelAndView delete(@PathVariable Long id){
        Student student = studentService.findById(id);

            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("student",student);
            return modelAndView;

    }
    @PostMapping("delete-student")
    public String delete(@ModelAttribute("customer") Student student) {
        studentService.remove(student.getId());
        return "redirect:list-students";
    }



}
