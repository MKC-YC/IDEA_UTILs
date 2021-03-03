package com.tian.service.impl;

import com.tian.dao.ApartmentDao;
import com.tian.domain.Apartment;
import com.tian.domain.Dorm;
import com.tian.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("apartmentService")
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    public ApartmentDao dao;

    @Override
    public void saveApartment(Apartment ap) {
        dao.add(ap);
    }

    @Override
    public List<Apartment> findAll() {
        List<Apartment> all = dao.findAll();
        return all;
    }

    @Override
    public Integer update(Apartment ap) {
        return dao.update(ap);
    }

    @Override
    public List<Dorm> findDormList(Integer apartmentId) {
        List<Dorm> dorms = dao.selectDormid(apartmentId);
        return dorms;
    }

    @Override
    public Integer currentNumber(Integer apartmentId) {
        return dao.currentNumber(apartmentId);
    }

    @Override
    public List<Integer> selectApartmentId() {
        return dao.selectApartmentId();
    }

    @Override
    public Apartment findOne(Integer apartmentid) {
        return dao.findOne(apartmentid);
    }

    @Override
    public void delete(Integer apartmentid) {
        dao.delete(apartmentid);
    }
}
