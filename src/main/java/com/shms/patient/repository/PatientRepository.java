package com.shms.patient.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shms.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByNameAndDob(String name, LocalDate dob);

    @Query("""
    SELECT p FROM Patient p WHERE
    LOWER(p.name) LIKE LOWER(CONCAT('%', :k, '%')) OR
    p.phone LIKE %:k% OR
    p.uhid LIKE %:k%
    """)
    List<Patient> search(String k);
}
