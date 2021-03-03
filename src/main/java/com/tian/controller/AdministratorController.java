package com.tian.controller;

import com.tian.domain.Administrator;
import com.tian.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/administrator")
@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Administrator> all = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("all",all);
        mv.setViewName("administratorList");
        return mv;
    }

    @RequestMapping("/add")
    public String add(){
        return "addAdministrator";
    }

    @RequestMapping("/insert")
    public String insert(Administrator ad){
        service.addAdministrator(ad);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(Integer ad_id){
        service.delete(ad_id);
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public ModelAndView update(Integer ad_id){
        Administrator one = service.findOne(ad_id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("administrator",one);
        mv.setViewName("updateAdministrator");
        return mv;
    }

    @RequestMapping("/updateAd")
    public String updateAd(Administrator administrator){
        service.update(administrator);
        return "redirect:findAll";
    }
}
