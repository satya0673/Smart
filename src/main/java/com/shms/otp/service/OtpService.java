package com.shms.otp.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.shms.mail.service.MailService;
import com.shms.otp.entity.Otp;
import com.shms.otp.repository.OtpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository repo;
    private final MailService mailService;

    public void sendOtp(String email) {

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        Otp o = new Otp();
        o.setEmail(email);
        o.setCode(otp);
        o.setExpiry(LocalDateTime.now().plusMinutes(5));
        o.setVerified(false);

        repo.save(o);

        mailService.sendOtp(email, otp);
    }

    public void verifyOtp(String email, String input) {

        Otp otp = repo.findTopByEmailOrderByIdDesc(email)
                .orElseThrow();

        if (otp.getExpiry().isBefore(LocalDateTime.now()))
            throw new RuntimeException("Expired");

        if (!otp.getCode().equals(input))
            throw new RuntimeException("Invalid");

        otp.setVerified(true);
        repo.save(otp);
    }

    public void validateVerified(String email) {

        Otp otp = repo.findTopByEmailOrderByIdDesc(email)
                .orElseThrow();

        if (!otp.isVerified())
            throw new RuntimeException("OTP not verified");
    }
}
