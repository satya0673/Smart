package com.shms.patient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shms.patient.dto.PatientRequestDto;
import com.shms.patient.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
	
	private final PatientService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody PatientRequestDto dto){
		return ResponseEntity.ok(service.register(dto));
		
	}
	@GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }

}
