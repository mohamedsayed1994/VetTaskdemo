package com.test.Relationdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "[0-9]+", message = "phone should be number only")
    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "bio")
    private String bio;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    public Doctor() {
    }

    public Doctor(@NotBlank String name, @Pattern(regexp = "[0-9]+", message = "phone should be number only") String phone, String bio) {
        this.name = name;
        this.phone = phone;
        this.bio = bio;
    }
}
