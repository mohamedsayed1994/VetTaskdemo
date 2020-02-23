package com.test.Relationdemo.entity.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Embeddable
public class ContactInfoVo {
    @Column(name = "address")
    private String address;

    @Pattern(regexp = "[0-9]+", message = "phone should be number only")
    @Column(name = "phone")
    private String phone;
    @Email(message = "email patters in wrong")
    @Column(name = "email")
    private String email;

    public ContactInfoVo(){

    }

    public ContactInfoVo(String address, @Pattern(regexp = "[0-9]+", message = "phone should be number only") String phone, @Email(message = "email patters in wrong") String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
