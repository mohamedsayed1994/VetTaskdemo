package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Owner;
import com.test.Relationdemo.entity.Pet;
import com.test.Relationdemo.entity.Visit;

import java.util.List;

public interface OwnerService {
    List<Owner> findAll();

    Owner findById(Long id);

    void saveOwner(Owner owner);

    List<Pet> findAllByOwnerId(Long ownerId);

    Visit createVisit(Visit visit);
}
