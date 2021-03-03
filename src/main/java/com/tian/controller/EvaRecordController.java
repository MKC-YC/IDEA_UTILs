package com.tian.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.tian.domain.Dorm;
import com.tian.domain.EvaRecord;
import com.tian.service.DormService;
import com.tian.service.EvaRecordService;
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

@RequestMapping("/evaRecord")
@Controller
public class EvaRecordController {
    @Autowired
    private EvaRecordService service;


    @Autowired
    private DormService dormService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize){
        List<EvaRecord> all = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(all);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("evarecordList");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add(){
        List<Integer> list = dormService.selectDormId();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("addEvaRecord");
        return mv;
    }
    @RequestMapping("/insert")
    public String insert(EvaRecord record){
        service.insertRec(record);
        return "redirect:findAll";
    }

    @RequestMapping("/updateRecord")
    public ModelAndView updateRecord(Integer evaRecordId){
        EvaRecord evaRecord = service.findByRecId(evaRecordId);
        List<Dorm> selectedDorm = dormService.getDormByEvaId(evaRecordId);
        List<Dorm> noSelectedDorm = dormService.getnotDormByEvarecordid(evaRecordId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("selectedDorm",selectedDorm);
        mv.addObject("noselectedDorm",noSelectedDorm);
        mv.addObject("evaRecord",evaRecord);
        mv.setViewName("updateEvaRecord");
        return  mv;
    }

    @RequestMapping("/selectedDorm")
    public void selectedDorm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String evarecordId = request.getParameter("evarecordId");
        List<Dorm> dormByEvaId = dormService.getDormByEvaId(Integer.parseInt(evarecordId));
//        System.out.println(dormByEvaId);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <dormByEvaId.size() ; i++) {
            Dorm dorm = dormByEvaId.get(i);
            list.add(dorm.getDormid());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }
    @RequestMapping("/noselectedDorm")
    public void noselectedDorm(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String evarecordid = request.getParameter("evarecordid");
        List<Dorm> dorms = dormService.getnotDormByEvarecordid(Integer.parseInt(evarecordid));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <dorms.size() ; i++) {
            Dorm dorm = dorms.get(i);
            list.add(dorm.getDormid());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),list);
    }
    @RequestMapping("/update")
    public String update(Integer evaRecordid, String title,String content,
                         @RequestParam(required = false) Integer[] dormid){
        EvaRecord  record = new EvaRecord();
        record.setEvaRecordid(evaRecordid);
        record.setTitle(title);
        record.setContent(content);
        Integer result = service.updateRec(record);
        System.out.println(result);
        if(dormid.length !=0){
        for (int i = 0; i <dormid.length ; i++) {
            dormService.addDormAndEva(evaRecordid,dormid[i]);
        }}
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(Integer recordId){
        service.deleteRec(recordId);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteList")
    public String delete(String str){
        String[] s = str.split(",");
        if(s.length>0){
            for (int i = 0; i < s.length; i++) {
                if(service.findByRecId(Integer.parseInt(s[i])).getDorms().size()==0){
                    service.deleteRec(Integer.parseInt(s[i]));
                }
            }
        }
        return "redirect:findAll";
    }
    @RequestMapping("/fuzzyQuery")
    public ModelAndView fuzzyQuery(String str){
        String string = "%" + str + "%";
        List<EvaRecord> evaRecords = service.fuzzyQuery(string);
        PageInfo pageInfo = new PageInfo(evaRecords);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("evarecordList");
        return mv;
    }

    @RequestMapping("/findDetail")
    public ModelAndView findDetail(Integer evaRecordId){
        EvaRecord evaRecord = service.findByRecId(evaRecordId);
        List<Dorm> dorms = evaRecord.getDorms();
        ModelAndView  mv = new ModelAndView();
        mv.addObject("evaRecord",evaRecord);
        mv.addObject("dorms",dorms);
        mv.setViewName("evaRecordDetail");
        return  mv;
    }
}
