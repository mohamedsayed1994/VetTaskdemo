package com.test.Relationdemo.controller;

import com.test.Relationdemo.entity.Doctor;
import com.test.Relationdemo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctors")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> findAllDoctor() {
        return doctorService.findAll();
    }

    @GetMapping("{id}")
    public Doctor findDoctorById(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return doctor;
    }

    @PutMapping
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return doctor;
    }


}
