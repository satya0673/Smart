package com.shms.patient.service;

import org.springframework.stereotype.Service;

import com.shms.patient.entity.Patient;
import com.shms.patient.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientMergeService {
	
	private final PatientRepository repo;
	
	public void merge(Long p1, Long p2)
	{
		  Patient a = repo.findById(p1).orElseThrow();
	        Patient b = repo.findById(p2).orElseThrow();

	        if (a.getPhone() == null)
	            a.setPhone(b.getPhone());

	        b.setActive(false);
	}

}
