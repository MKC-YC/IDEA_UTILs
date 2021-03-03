package com.tian.service;

import com.tian.domain.Visitor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VisitorService {
    List<Visitor> findAll(Integer page,Integer pageSize);
    void add(Visitor visitor);

    void update(Visitor visitor);

    void delete(Integer vid);

    Visitor findOne(Integer vid);
}
