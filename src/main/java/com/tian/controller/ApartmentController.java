package com.tian.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tian.domain.Apartment;
import com.tian.domain.Dorm;
import com.tian.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/apartment")
@Controller
public class ApartmentController {

    @Autowired
    @Qualifier("apartmentService")
    private ApartmentService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Apartment> all = service.findAll();
        HashMap<Apartment,Integer> map = new HashMap<>();
        for (Apartment ap:all
             ) {

            map.put(ap,service.currentNumber(ap.getApartmentid()));
        }
        ModelAndView mv = new ModelAndView();

        mv.addObject("map",map);
        mv.setViewName("apartmentList");
        return mv;
    }



    @RequestMapping("/add")
    public String add(){
        return "addApartment";
    }
    @RequestMapping("/insert")
    public String insert(Integer fee,Integer maxoccupancy){
        Apartment ap = new Apartment();
        ap.setFee(fee);
        ap.setMaxoccupancy(maxoccupancy);
        service.saveApartment(ap);
        return "redirect:findAll";
    }

    @RequestMapping("/apartmentDetail")
    public ModelAndView apartmentDetail(Integer apId){
        List<Dorm> dormList = service.findDormList(apId);
        Apartment one = service.findOne(apId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("dorms",dormList);
        mv.addObject("apartment",one);
        mv.setViewName("apartmentDetail");
        return mv;
    }

    @RequestMapping("/updateap")
    public ModelAndView updateap(Integer apId){
        Apartment one = service.findOne(apId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("apartment",one);
        mv.setViewName("updateApartment");
        return mv;
    }
    @RequestMapping("/update")
    public String update(Integer apartmentid,Integer fee ,Integer maxoccupancy){
        Apartment ap = new Apartment();
        ap.setMaxoccupancy(maxoccupancy);
        ap.setFee(fee);
        ap.setApartmentid(apartmentid);
        service.update(ap);
        return "redirect:findAll";
    }

    @RequestMapping("/apIdList")
    public void apartmentIdList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String dormId = request.getParameter("dormid");
        List<Integer> list = service.selectApartmentId();
        ObjectMapper mapper= new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }

    @RequestMapping("/delete")
    public String delete(Integer apartmentid){
        service.delete(apartmentid);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteList")
    public String deleteList(String string){
        String[] str = string.split(",");
        if (str.length>0){
            for (int i = 0; i <str.length ; i++) {
                if(service.findOne(Integer.parseInt(str[i])).getDorms().size()==0){
                    service.delete(Integer.parseInt(str[i]));
                }
            }
        }

        return "redirect:findAll";
    }
}
