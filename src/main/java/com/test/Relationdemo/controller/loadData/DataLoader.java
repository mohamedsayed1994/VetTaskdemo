package com.test.Relationdemo.controller.loadData;

import com.test.Relationdemo.entity.*;
import com.test.Relationdemo.entity.enums.Gender;
import com.test.Relationdemo.entity.vo.ContactInfoVo;
import com.test.Relationdemo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final DoctorService doctorService;
    private final ClinicService clinicService;
    private final OwnerService ownerService;
    private final PetService petService;
    public final VisitService visitService;

    @Autowired
    public DataLoader(DoctorService doctorService, ClinicService clinicService, OwnerService ownerService, PetService petService, VisitService visitService) {
        this.doctorService = doctorService;
        this.clinicService = clinicService;
        this.ownerService = ownerService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ContactInfoVo contact = new ContactInfoVo("cairo", "222", "b@b.com");
        ContactInfoVo contact2 = new ContactInfoVo("alex", "333", "c@c.com");
        ContactInfoVo contact3 = new ContactInfoVo("cairo", "444", "a@a.com");

        Clinic clinic2 = new Clinic("ss", contact3, "www.test.com");
        Clinic clinic1 = new Clinic("Clinic 1", contact2, "www.test.com");
        clinicService.saveClinic(clinic2);
        clinicService.saveClinic(clinic1);

        Doctor doctor1 = new Doctor("A", "012222", "Test Test TESt");
        Doctor doctor2 = new Doctor("B", "00000", "testtes trest");
        Doctor doctor3 = new Doctor("C", "00055", "testsetest st sete");
        doctor1.setClinic(clinic1);
        doctor2.setClinic(clinic2);
        doctor3.setClinic(clinic1);
        doctorService.saveDoctor(doctor1);
        doctorService.saveDoctor(doctor2);
        doctorService.saveDoctor(doctor3);

        Owner owner1 = new Owner("Owner 1", contact, Gender.MALE);
        Owner owner2 = new Owner("Owner 2", contact2, Gender.FEMALE);
        ownerService.saveOwner(owner1);
        ownerService.saveOwner(owner2);

        Pet pet1 = new Pet("pet1", Gender.FEMALE, LocalDate.of(1994, 1, 1), "pet1", 100);
        Pet pet2 = new Pet("pet2", Gender.FEMALE, LocalDate.of(1994, 1, 1), "pet2", 100);
        Pet pet3 = new Pet("pet3", Gender.FEMALE, LocalDate.of(1994, 1, 1), "pet3", 100);
        Pet pet4 = new Pet("pet4", Gender.FEMALE, LocalDate.of(1994, 1, 1), "pet4", 100);
        pet1.setOwner(owner1);
        pet3.setOwner(owner1);
        pet2.setOwner(owner1);
        pet4.setOwner(owner2);
        petService.savePet(pet1);
        petService.savePet(pet2);
        petService.savePet(pet3);
        petService.savePet(pet4);

        Visit visit1 = new Visit(LocalDate.of(2025, 1, 1), pet1, doctor1, clinic1);
        Visit visit2 = new Visit(LocalDate.of(2025, 1, 1), pet3, doctor2, clinic2);
        Visit visit3 = new Visit(LocalDate.of(2025, 1, 1), pet4, doctor3, clinic1);

        visitService.saveVisit(visit1);
        visitService.saveVisit(visit2);
        visitService.saveVisit(visit3);


//        clinic1.addDoctor(doctor1);
//        clinic1.addDoctor(doctor2);
//        clinic2.addDoctor(doctor3);


    }
}
