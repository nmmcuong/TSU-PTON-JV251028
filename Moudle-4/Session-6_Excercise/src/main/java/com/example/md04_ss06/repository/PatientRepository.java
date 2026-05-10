package com.example.md04_ss06.repository;

import com.example.md04_ss06.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.fullName LIKE %:patientName%")
    Page<Patient> findAllAndSearch(Pageable pageable , @RequestParam("patientName") String patientName);
}
