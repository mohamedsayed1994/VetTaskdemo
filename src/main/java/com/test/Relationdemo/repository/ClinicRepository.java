package com.test.Relationdemo.repository;


import com.test.Relationdemo.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic,Long> {
    @Query("SELECT c FROM Clinic c where c.contactInfoVo.address LIKE %:address% OR c.contactInfoVo.phone LIKE %:phone%")
    List<Clinic> searchByAddressOrPhone(String address, String phone);
}
