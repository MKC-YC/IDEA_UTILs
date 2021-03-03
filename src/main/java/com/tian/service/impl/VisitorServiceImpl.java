package com.tian.service.impl;

import com.github.pagehelper.PageHelper;
import com.tian.dao.VisitorDao;
import com.tian.domain.Visitor;
import com.tian.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao dao;
    @Override
    public List<Visitor> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public void add(Visitor visitor) {
        dao.add(visitor);
    }

    @Override
    public void update(Visitor visitor) {
        dao.update(visitor);
    }

    @Override
    public void delete(Integer vid) {
        dao.delete(vid);
    }

    @Override
    public Visitor findOne(Integer vid) {
        return dao.findOne(vid);
    }
}
