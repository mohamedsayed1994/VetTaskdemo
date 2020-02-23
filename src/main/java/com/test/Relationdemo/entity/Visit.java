package com.test.Relationdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "visit_Date")
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    public Visit() {
    }

    public Visit(LocalDate visitDate, Pet pet, Doctor doctor, Clinic clinic) {
        this.visitDate = visitDate;
        this.pet = pet;
        this.doctor = doctor;
        this.clinic = clinic;
    }
}
