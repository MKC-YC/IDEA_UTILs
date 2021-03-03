package com.tian.service.impl;

import com.github.pagehelper.PageHelper;
import com.tian.dao.EvaRecordDao;
import com.tian.domain.EvaRecord;
import com.tian.service.EvaRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("evaRecordService")
public class EvaRecordServiceImpl implements EvaRecordService {

    @Autowired
    private EvaRecordDao dao;
    @Override
    public void insertRec(EvaRecord record) {
        dao.insertRec(record);
    }

    @Override
    public void deleteRec(Integer reid) {
        dao.deleteRec(reid);
    }

    @Override
    public Integer updateRec(EvaRecord record) {
        return dao.updateRec(record);
    }

    @Override
    public List<EvaRecord> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public EvaRecord findByRecId(Integer recId) {
        return dao.findByRecId(recId);
    }

    @Override
    public List<EvaRecord> getEvaRecordByDormid(Integer dormid) {
        return dao.getEvaRecordByDormid(dormid);
    }

    @Override
    public List<EvaRecord> fuzzyQuery(String str) {
        return dao.fuzzyQuery(str);
    }
}
