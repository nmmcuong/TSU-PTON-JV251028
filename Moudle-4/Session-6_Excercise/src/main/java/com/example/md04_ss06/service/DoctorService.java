package com.example.md04_ss06.service;

import com.example.md04_ss06.model.entity.Doctor;
import com.example.md04_ss06.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id){
       doctorRepository.deleteById(id);
    }

    public Doctor findDoctorById(Long id){
       return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Long id, Doctor doctor){
        Doctor updateDoctor = findDoctorById(id);
        if(updateDoctor != null){
            Doctor doctor1 = new Doctor();
            doctor1.setId(id);
            doctor1.setDoctorCode(doctor.getDoctorCode());
            doctor1.setFullName(doctor.getFullName());
            doctor1.setSpecialization(doctor.getSpecialization());
            doctor1.setExperienceYears(doctor.getExperienceYears());
            doctorRepository.save(doctor1);
            return doctor1;
        }
        return null;
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

}
