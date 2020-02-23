package com.test.Relationdemo.controller;

import com.test.Relationdemo.entity.Clinic;
import com.test.Relationdemo.entity.Doctor;
import com.test.Relationdemo.services.ClinicService;
import com.test.Relationdemo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {
    private final ClinicService clinicService;
    private final DoctorService doctorService;

    @Autowired
    public ClinicController(ClinicService clinicService, DoctorService doctorService) {
        this.clinicService = clinicService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Clinic> findAllClinic() {
        return clinicService.findAll();
    }

    @GetMapping("{id}")
    public Clinic findClinicById(@PathVariable Long id) {
        System.out.println("==========> id" + id);
        return clinicService.findById(id);
    }

    @GetMapping("{id}/doctors")
    public List<Doctor> getDoctorsOfClinic(@PathVariable Long id) {
        return doctorService.findAllByClinicId(id);
    }

    @PostMapping
    public Clinic addClinic(@RequestBody Clinic clinic) {
        clinicService.saveClinic(clinic);
        return clinic;
    }

    @PutMapping
    public Clinic updateClinic(@RequestBody Clinic clinic) {
        clinicService.saveClinic(clinic);
        return clinic;
    }

    @GetMapping("/search")
    public List<Clinic> findAllByAddressOrPhone(@RequestParam(value = "address", required = false) String address,
                                                   @RequestParam(value = "phone",required = false) String phone) {
        if (address == null && phone == null) {
            return clinicService.findAll();
        }
        return clinicService.searchByAddressOrPhone(address, phone);
    }
}
