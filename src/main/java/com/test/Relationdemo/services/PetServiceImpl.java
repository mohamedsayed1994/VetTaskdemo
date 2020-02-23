package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Pet;
import com.test.Relationdemo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public List<Pet> findAllByOwnerId(Long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}
