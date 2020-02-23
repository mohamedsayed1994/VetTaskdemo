package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Doctor;
import com.test.Relationdemo.entity.Owner;
import com.test.Relationdemo.entity.Pet;
import com.test.Relationdemo.entity.Visit;
import com.test.Relationdemo.repository.DoctorRepository;
import com.test.Relationdemo.repository.OwnerRepository;
import com.test.Relationdemo.repository.PetRepository;
import com.test.Relationdemo.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository, DoctorRepository doctorRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.doctorRepository = doctorRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> result = ownerRepository.findById(id);
        Owner owner = null;
        if (result.isPresent()) {
            owner = result.get();
        } else {
            throw new RuntimeException("=====> did not find the id " + id);
        }
        return owner;
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public List<Pet> findAllByOwnerId(Long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }

    public Visit createVisit(Visit visit) {
//        System.out.println("================> " + visit.getClinic().getId());
//        Long clinic = visit.getClinic().getId();
//        List<Doctor> doctors = doctorRepository.findAllByClinicId(clinic);
//        if (!doctors.contains(visit.getDoctor())) {
//            throw new RuntimeException("====> this doctor no in this clinic ");
//        }
        visitRepository.save(visit);
        return visit;
    }
}
