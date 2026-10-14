package com.shms.patient.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PatientRequestDto {
	  private String name;
	    private LocalDate dob;
	    private String phone;
	    private String email;

}
