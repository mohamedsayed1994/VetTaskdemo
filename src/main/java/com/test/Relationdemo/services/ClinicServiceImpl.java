package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Clinic;
import com.test.Relationdemo.entity.Doctor;
import com.test.Relationdemo.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final ClinicRepository clinicRepository;
    private final DoctorService doctorService;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository, DoctorService doctorService) {
        this.clinicRepository = clinicRepository;
        this.doctorService = doctorService;
    }

    @Override
    public List<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic findById(Long id) {
        Optional<Clinic> result = clinicRepository.findById(id);
        Clinic clinic = null;
        if (result.isPresent()) {
            clinic = result.get();
        } else {
            throw new RuntimeException("did not find the id " + id);
        }
        return clinic;
    }

    @Override
    public void saveClinic(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    @Override
    public List<Doctor> findAllByClinicId(Long clinicId) {
        return doctorService.findAllByClinicId(clinicId);
    }

    @Override
    public List<Clinic> searchByAddressOrPhone(String address, String phone) {
        return clinicRepository.searchByAddressOrPhone(address,phone);
    }
}
