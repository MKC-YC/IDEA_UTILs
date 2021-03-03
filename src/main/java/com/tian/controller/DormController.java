package com.tian.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.domain.Dorm;
import com.tian.domain.EvaRecord;
import com.tian.domain.Student;
import com.tian.service.ApartmentService;
import com.tian.service.DormService;
import com.tian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    private DormService service;

    @Autowired
    private ApartmentService apservice;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page ,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize) {
        List<Dorm> all = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("dormList");
        return mv;
    }


    @RequestMapping("/add")
    public ModelAndView  addDorm(){
        List<Integer> list = apservice.selectApartmentId();
        ModelAndView mv = new ModelAndView();
        mv.addObject("apIds",list);
        mv.setViewName("addDorm");
        return mv;
    }

    @RequestMapping("/insert")
    public String save(Dorm dorm){
        service.addDorm(dorm);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(Integer dormid){
        service.delete(dormid);
        return "redirect:findAll";
    }

    @RequestMapping("/updateDorm")
    public ModelAndView updateDorm(Integer dormid){
        Dorm dorm = service.findOne(dormid);
        List<Integer> apartmentIds = apservice.selectApartmentId();
        ModelAndView mv = new ModelAndView();
        mv.addObject("dorm",dorm);
        mv.addObject("apartmentIds",apartmentIds);
        mv.setViewName("updateDorm");
        return mv;
    }
    @RequestMapping("/update")
    public String update(Dorm dorm){
        service.updateDorm(dorm);
        return "redirect:findAll";
    }

    @RequestMapping("/findDetails")
    public ModelAndView findDetails(Integer dormid){
        Dorm one = service.findOne(dormid);
        List<EvaRecord> evaRecords = one.getEvaRecords();
        List<Student> students = one.getStudents();
        ModelAndView mv = new ModelAndView();
        mv.addObject("dorm",one);
        mv.addObject("evaluationRecord",evaRecords);
        mv.addObject("students",students);
        mv.setViewName("dormDetail");
        return mv;
    }

    @RequestMapping("/insertDormAndStudent")
    public String insertDormAndStudent(Integer dormId,Integer stuId){
        service.addDormAndStudent(dormId,stuId);
        return "redirect:findAll";
    }

    @RequestMapping("/insertDormAndRecord")
    public String insertDormAndRecord(Integer dormId,Integer recId){
        service.addDormAndEva(dormId,recId);
        return "redirect:findAll";
    }

    @RequestMapping("/fuzzyQuery")
    public ModelAndView fuzzyQuery(String str){
        String st = "%" + str + "%";
        List<Dorm> dorms = service.fuzzyQuery(st);
        PageInfo pageInfo = new PageInfo(dorms);
        ModelAndView mv= new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("dormList");
        return  mv;
    }

    @RequestMapping("/selectDormId")
    public List<Integer> selectDormId() throws JsonProcessingException {
        List<Integer> dormIds = service.selectDormId();
        ObjectMapper mapper =  new ObjectMapper();
        String str = mapper.writeValueAsString(dormIds);
        return dormIds;
    }

    @RequestMapping("/findDamagedDorm")
    public ModelAndView findDamagedDorm(){
        List<Dorm> damagedDorm = service.findDamagedDorm();
        PageInfo pageInfo= new PageInfo(damagedDorm);
        ModelAndView mv = new ModelAndView();
        //是否使用分页查询
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("dormList");
        return mv;
    }

    @RequestMapping("/deleteList")
    public String deleteList(String string){
        String[] str = string.split(",");
            if (str.length>0){
                for (int i = 0; i <str.length ; i++) {
                    if(service.findOne(Integer.parseInt(str[i])).getStudents().size()==0 && service.findOne(Integer.parseInt(str[i])).getEvaRecords().size() == 0 ){
                        service.delete(Integer.parseInt(str[i]));
                    }
                }
            }

        return "redirect:findAll";
    }

    @RequestMapping("/dormidList")
    public void dormidList(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<Integer> list = service.selectDormId();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }
}
