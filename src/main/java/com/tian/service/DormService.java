package com.tian.service;

import com.tian.dao.DormDao;
import com.tian.domain.Dorm;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DormService {
    List<Dorm> findAll(Integer page,Integer pageSize);
     void addDorm(Dorm dorm);
    void delete(Integer dormid);
    Integer updateDorm(Dorm dorm);
    Dorm findOne(Integer dormid);
    List<Dorm> getDormByEvaId(Integer evarecordid);
    void addDormAndEva(Integer evarecord,Integer dormid);
    void addDormAndStudent(Integer dormId,Integer stuId);
    List<Dorm> fuzzyQuery(String str);

    List<Integer> selectDormId();

    List<Dorm> findAllWithoutPage();

    List<Dorm> findDamagedDorm();


    List<Dorm> getnotDormByEvarecordid(Integer evarecordid);
}
