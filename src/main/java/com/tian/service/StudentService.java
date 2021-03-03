package com.tian.service;

import com.tian.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll(Integer page ,Integer pageSize);
    void saveStudent(Student stu);
    Integer update(Student student);
    void delete(Integer stuId);
    Student findByStuId(Integer stuId);
    List<Student> findByDormId(Integer dormId);
    List<Student> fuzzyQuery(String str);
}
