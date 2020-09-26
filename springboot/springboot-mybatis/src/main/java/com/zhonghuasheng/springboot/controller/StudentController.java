package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.entity.Student;
import com.zhonghuasheng.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable long id) {
        return studentService.getStudentById(id);
    }
}
