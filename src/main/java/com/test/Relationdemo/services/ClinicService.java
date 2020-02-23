package com.test.Relationdemo.services;


import com.test.Relationdemo.entity.Clinic;
import com.test.Relationdemo.entity.Doctor;

import java.util.List;

public interface ClinicService {
    List<Clinic> findAll();

    Clinic findById(Long id);

    void saveClinic(Clinic clinic);

    List<Doctor> findAllByClinicId(Long clinicId);

    List<Clinic> searchByAddressOrPhone(String address, String phone);

}
