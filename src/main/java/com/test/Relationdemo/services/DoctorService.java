package com.test.Relationdemo.services;

import com.test.Relationdemo.entity.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> findAll();

    public Doctor findById(Long id);

    public void saveDoctor(Doctor doctor);

    List<Doctor> findAllByClinicId(Long clinicId);

}
