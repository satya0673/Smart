package com.shms.otp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Otp {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String code;
    private LocalDateTime expiry;
    private boolean verified;
}