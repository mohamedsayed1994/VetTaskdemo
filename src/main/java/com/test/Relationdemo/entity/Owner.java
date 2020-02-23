package com.test.Relationdemo.entity;

import com.test.Relationdemo.entity.enums.Gender;
import com.test.Relationdemo.entity.vo.ContactInfoVo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Embedded
    private ContactInfoVo contactInfoVo;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Owner() {
    }

    public Owner(@NotBlank String name, ContactInfoVo contactInfoVo, Gender gender) {
        this.name = name;
        this.contactInfoVo = contactInfoVo;
        this.gender = gender;
    }
}
