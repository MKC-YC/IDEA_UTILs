package com.tian.controller;

import com.github.pagehelper.PageInfo;
import com.tian.domain.Visitor;
import com.tian.service.VisitorService;
import com.tian.utils.DateUtils;
import org.apache.ibatis.annotations.Many;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page ,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize){
        List<Visitor> all = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("visitorList");
        return mv;
    }


    @RequestMapping("/insert")
    public String insert(String viname,String vitime,String  telephone,String remark) throws ParseException {
        Visitor visitor = new Visitor();
        visitor.setRemark(remark);
        visitor.setTelephone(telephone);

        visitor.setViname(viname);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = sdf.parse(viname);
        Date date = DateUtils.String2Date(vitime, "yyyy-MM-dd");

        visitor.setVitime(date);
        service.add(visitor);
        return "redirect:findAll";
    }

    @RequestMapping("/addVisitor")
    public String addVisitor(){
        return "addVisitor";
    }

    @RequestMapping("/delete")
    public String delete(Integer vid){
        service.delete(vid);
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String update(Integer vid,String viname,String vitime,String telephone,String remark) throws ParseException {
        Visitor visitor = new Visitor();
        visitor.setTelephone(telephone);
        Date date = DateUtils.String2Date(vitime, "yyyy-MM-dd");
        visitor.setVitime(date);
        visitor.setViname(viname);
        visitor.setRemark(remark);
        visitor.setVid(vid);
        service.update(visitor);
        return "redirect:findAll";
    }

    @RequestMapping("/updateVi")
    public ModelAndView updateVi(Integer vid){
        Visitor one = service.findOne(vid);
        ModelAndView mv =new ModelAndView();
        mv.addObject("visitor",one);
        mv.setViewName("updateVisitor");
        return mv;
    }
}
