package com.zhonghuasheng.springboot.service.impl;

import com.zhonghuasheng.springboot.dao.StudentDAO;
import com.zhonghuasheng.springboot.entity.Student;
import com.zhonghuasheng.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student getStudentById(long id) {
        return studentDAO.select(id);
    }
}
