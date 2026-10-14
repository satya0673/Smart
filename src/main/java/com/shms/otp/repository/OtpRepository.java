package com.shms.otp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shms.otp.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findTopByEmailOrderByIdDesc(String email);
}
