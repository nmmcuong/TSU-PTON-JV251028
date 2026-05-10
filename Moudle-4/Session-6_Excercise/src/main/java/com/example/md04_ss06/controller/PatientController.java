package com.example.md04_ss06.controller;

import com.example.md04_ss06.model.dto.PaginationResponse;
import com.example.md04_ss06.model.dto.PatientDTO;
import com.example.md04_ss06.model.entity.Patient;
import com.example.md04_ss06.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.savePatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long id){
        Patient deletePatient = patientService.findPatientById(id);
        if(deletePatient == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy bệnh nhân có mã là: " + id);
        }else{
            patientService.deletePatientById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Đã xóa thành công bệnh nhân có mã là: " + id);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<PaginationResponse<PatientDTO>> searchPatientsByName(
            @RequestParam String patientName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(patientService.searchPatients(patientName, page, size));
    }
}
