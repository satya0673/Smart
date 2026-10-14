package com.shms.patient.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.shms.otp.service.OtpService;
import com.shms.patient.dto.PatientRequestDto;
import com.shms.patient.entity.Patient;
import com.shms.patient.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {
	
	private final PatientRepository repo;
	private final OtpService otpService;
	
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('RECEPTIONIST')")
	public Patient register(PatientRequestDto dto)
	{
		
		otpService.validateVerified(dto.getEmail());
		Patient p=new Patient();
		p.setName(dto.getName());
		p.setDob(dto.getDob());
		p.setPhone(dto.getPhone());
		p.setEmail(dto.getEmail());
		
		repo.save(p);
		
		p.setUhid("SHMS-"+ p.getId());
		return p;
		
	}
	 public List<Patient> search(String k) {
	        return repo.search(k);
	    }

}
