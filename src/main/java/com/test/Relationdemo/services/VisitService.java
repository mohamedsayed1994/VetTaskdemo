package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Visit;

import java.util.List;

public interface VisitService {
    List<Visit> findAll();

    Visit findById(Long id);

    void saveVisit(Visit visit);
}
