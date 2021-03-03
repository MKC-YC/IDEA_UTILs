package com.tian.service;

import com.tian.domain.EvaRecord;

import java.util.List;

public interface EvaRecordService {
        void insertRec(EvaRecord record);
        void deleteRec(Integer reid);
        Integer updateRec(EvaRecord record);
        List<EvaRecord> findAll(Integer page ,Integer pageSize);
        EvaRecord findByRecId(Integer recId);
        List<EvaRecord> getEvaRecordByDormid(Integer dormid);
        List<EvaRecord> fuzzyQuery(String str);
}
