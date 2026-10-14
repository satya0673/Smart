package com.shms.patient.entity;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@SQLDelete(sql = "UPDATE patients SET active=false WHERE id=?")
@Where(clause = "active=true")
@Getter
@Setter
public class Patient {
	
	 @Id
	 @GeneratedValue
	    private Long id;

	    private String uhid;
	    private String name;
	    private LocalDate dob;
	    private String phone;
	    private String email;

	    private boolean active = true;
	

}
