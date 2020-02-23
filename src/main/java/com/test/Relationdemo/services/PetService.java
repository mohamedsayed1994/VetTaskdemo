package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Pet;

import java.util.List;

public interface PetService {
    List<Pet> findAll();

    Pet findById(Long id);

    void savePet(Pet pet);

    List<Pet> findAllByOwnerId(Long ownerId);
}
