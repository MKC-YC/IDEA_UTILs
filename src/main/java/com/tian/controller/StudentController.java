package com.tian.controller;

import com.github.pagehelper.PageInfo;
import com.tian.domain.Dorm;
import com.tian.domain.Student;
import com.tian.service.DormService;
import com.tian.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private DormService dormService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true,defaultValue = "10")Integer pageSize){

        List<Student> all = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("studentList");
        return  mv;
    }

    @RequestMapping("/save")
    public String save(Student student){
        service.saveStudent(student);
        return "redirect:findAll";
    }

    @RequestMapping("/updateStudent")
    public ModelAndView updateStudent(Integer stuid){
        Student byStuId = service.findByStuId(stuid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student",byStuId);
        mv.setViewName("updateStudent");
        return mv;
    }
    @RequestMapping("/update")
    public String update(Student student){
        Integer update = service.update(student);
        System.out.println(update);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete( Integer stuid){
          service.delete(stuid);
        return "redirect:findAll";
    }

    @RequestMapping("/fuzzyQuery")
    public ModelAndView fuzzyQuery(String str){
        String string  = "%" + str + "%";
        List<Student> students = service.fuzzyQuery(string);
        PageInfo pageInfo = new PageInfo(students);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("studentList");
        return mv;
    }
    @RequestMapping("/addStudent")
    public ModelAndView addStudent(){
        List<Dorm> dorms = dormService.findAllWithoutPage();
        ModelAndView mv = new ModelAndView();
        mv.addObject("dorms",dorms);
        mv.setViewName("addStudent");
        return mv;
    }

    @RequestMapping("/deleteList")
    public String deleteList(String string){
        String[] split = string.split(",");
        if(split.length>0){
            for (int i = 0; i < split.length; i++) {
                service.delete(Integer.parseInt(split[i]));
            }
        }
        return "redirect:findAll";
    }
}
