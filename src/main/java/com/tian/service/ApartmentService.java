package com.tian.service;

import com.tian.domain.Apartment;
import com.tian.domain.Dorm;

import java.util.List;

public interface ApartmentService {
    public void saveApartment(Apartment ap);

    public List<Apartment> findAll();
    public Integer update(Apartment ap);

    public List<Dorm> findDormList(Integer apartmentId);

    public Integer currentNumber(Integer apartmentId);

    public List<Integer> selectApartmentId();

    public Apartment findOne(Integer apartmentid);

    public void  delete(Integer apartmentid);
}
