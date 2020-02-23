package com.test.Relationdemo.entity;


import com.test.Relationdemo.entity.vo.ContactInfoVo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Embedded
    private ContactInfoVo contactInfoVo;

    @Column(name = "social_networks_url")
    private String socialNetworksUrl;

    public Clinic() {
    }

    public Clinic(@NotBlank String name, ContactInfoVo contactInfoVo, String socialNetworksUrl) {
        this.name = name;
        this.contactInfoVo = contactInfoVo;
        this.socialNetworksUrl = socialNetworksUrl;
    }
}
