package com.tian.service.impl;

import com.github.pagehelper.PageHelper;
import com.tian.dao.StudentDao;
import com.tian.domain.Student;
import com.tian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao dao;
    @Override
    public List<Student> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public void saveStudent(Student stu) {
        dao.saveStudent(stu);
    }

    @Override
    public Integer update(Student student) {
        return dao.update(student);
    }

    @Override
    public void delete(Integer stuId) {
        dao.delete(stuId);
    }

    @Override
    public Student findByStuId(Integer stuId) {
        return dao.findbystuid(stuId);
    }

    @Override
    public List<Student> findByDormId(Integer dormId) {
        return dao.findbydormid(dormId);
    }

    @Override
    public List<Student> fuzzyQuery(String str) {
        List<Student> students = dao.fuzzyQuery(str);
        return students;
    }
}
