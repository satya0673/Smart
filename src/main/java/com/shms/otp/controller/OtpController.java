package com.shms.otp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shms.otp.service.OtpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService service;

    @PostMapping("/send")
    public String send(@RequestParam String email) {
        service.sendOtp(email);
        return "OTP sent";
    }

    @PostMapping("/verify")
    public String verify(@RequestParam String email,
                         @RequestParam String otp) {

        service.verifyOtp(email, otp);
        return "OTP verified";
    }
}