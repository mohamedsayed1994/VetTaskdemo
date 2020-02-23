package com.test.Relationdemo.controller;

import com.test.Relationdemo.entity.Pet;
import com.test.Relationdemo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pets")
@RestController
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> findAllPet() {
        return petService.findAll();
    }

    @GetMapping("{id}")
    public Pet findPetById(@PathVariable Long id) {
        return petService.findById(id);
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        petService.savePet(pet);
        return pet;
    }

    @PutMapping
    public Pet updatePet(@RequestBody Pet pet) {
        petService.savePet(pet);
        return pet;
    }
}
