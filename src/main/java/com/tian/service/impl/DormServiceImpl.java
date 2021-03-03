package com.tian.service.impl;

import com.github.pagehelper.PageHelper;
import com.tian.dao.DormDao;
import com.tian.domain.Dorm;
import com.tian.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dormService")
public class DormServiceImpl implements DormService {
    @Autowired
    private DormDao dao;
    @Override
    public List<Dorm> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }



    @Override
    public void addDorm(Dorm dorm) {
        dao.addDorm(dorm);
    }

    @Override
    public void delete(Integer dormid) {
        dao.delete(dormid);
    }

    @Override
    public Integer updateDorm(Dorm dorm) {
        return dao.updateDorm(dorm);
    }

    @Override
    public Dorm findOne(Integer dormid) {
        return dao.findOne(dormid);
    }

    @Override
    public List<Dorm> getDormByEvaId(Integer evarecordid) {
        return dao.getDormByEvaid(evarecordid);
    }

    @Override
    public void addDormAndEva(Integer evarecordid ,Integer dormid) {
        dao.addDormAndEva(evarecordid,dormid);
    }

    @Override
    public void addDormAndStudent(Integer dormId, Integer stuId) {
        dao.addDormAndStudent(dormId,stuId);
    }

    @Override
    public List<Dorm> fuzzyQuery(String str) {
        return dao.fuzzyQuery(str);
    }

    @Override
    public List<Integer> selectDormId() {
        return dao.selectDormId();
    }

    @Override
    public List<Dorm> findAllWithoutPage() {
        return dao.findAll();
    }

    @Override
    public List<Dorm> findDamagedDorm() {
        return dao.findDamagedDorm();
    }


    @Override
    public List<Dorm> getnotDormByEvarecordid(Integer evarecordid) {
        return dao.getnotDormByEvarecordid(evarecordid);
    }


}
