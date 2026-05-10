package com.example.md04_ss06.controller;

import com.example.md04_ss06.model.entity.Doctor;
import com.example.md04_ss06.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.status(201).body(doctorService.addDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id){
        Doctor foundDoctor = doctorService.findDoctorById(id);
        if(foundDoctor == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy bác sĩ có id là: " + id);
        }else{
            doctorService.deleteDoctor(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Xóa thành công bác sĩ có id là: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor){
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        if(updatedDoctor == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy bác sĩ có id là: " + id);
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedDoctor);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllDoctors(){
        List<Doctor> doctorList = doctorService.getAllDoctors();
        if(doctorList == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Danh sách bác sĩ trống");
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(doctorList);
        }
    }
}
