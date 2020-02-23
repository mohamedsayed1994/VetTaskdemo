package com.test.Relationdemo.entity;

import com.test.Relationdemo.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Past(message = "date of birth must be less than today")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "animal_Kind")
    private String animalKind;

//    @Lob
//    @Column(name = "photo",length=100000)
//    private byte[] photo;

    @Min(value = 1, message = "weight must be greater than 0")
    @Column(name = "weight")
    private double weight;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet() {
    }

    public Pet(@NotBlank String name, Gender gender, @Past(message = "date of birth must be less than today") LocalDate dateOfBirth, String animalKind, @Min(value = 1, message = "weight must be greater than 0") double weight) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.animalKind = animalKind;
        this.weight = weight;
    }
}
