package com.test.Relationdemo.controller;

import com.test.Relationdemo.entity.Doctor;
import com.test.Relationdemo.entity.Owner;
import com.test.Relationdemo.entity.Pet;
import com.test.Relationdemo.entity.Visit;
import com.test.Relationdemo.services.DoctorService;
import com.test.Relationdemo.services.OwnerService;
import com.test.Relationdemo.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owners")
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;

    }

    @GetMapping
    public List<Owner> findAllOwner() {
        return ownerService.findAll();
    }

    @GetMapping("{id}")
    public Owner findOwnerById(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @PostMapping
    public Owner addOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        return owner;
    }

    @PutMapping
    public Owner updateOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        return owner;
    }

    @GetMapping("{id}/pets")
    public List<Pet> getDoctorsOfClinic(@PathVariable Long id) {
        return ownerService.findAllByOwnerId(id);
    }

    @PostMapping("/visit")
    public Visit createVisit(Visit visit) {
//        System.out.println("================> " + visit.getClinic().getId());
//        Long clinic = visit.getClinic().getId();
//        List<Doctor> doctors = doctorService.findAllByClinicId(clinic);
//        if (!doctors.contains(visit.getDoctor())) {
//            throw new RuntimeException("====> this doctor no in this clinic ");
//        }
        ownerService.createVisit(visit);
        return visit;
    }
}
