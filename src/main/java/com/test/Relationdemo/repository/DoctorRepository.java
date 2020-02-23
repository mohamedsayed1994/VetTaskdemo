package com.test.Relationdemo.repository;

import com.test.Relationdemo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAllByClinicId(Long clinicId);
}
