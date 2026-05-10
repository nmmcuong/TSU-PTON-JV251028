package com.example.md04_ss06.service;

import com.example.md04_ss06.model.dto.PaginationResponse;
import com.example.md04_ss06.model.dto.PatientDTO;
import com.example.md04_ss06.model.entity.Patient;
import com.example.md04_ss06.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient findPatientById(Long id){
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatientById(Long id){
        patientRepository.deleteById(id);
    }

    public PaginationResponse<PatientDTO> searchPatients(String patientName, int page, int size){
        // B1: khởi tạo đối tượng Pageable và sắp xếp theo tên
        Pageable pageable = PageRequest.of(page, size, Sort.by("fullName").descending());

        // B2: lấy Page của đối tương Patient từ DB
        Page<Patient> patientPage = patientRepository.findAllAndSearch(pageable, patientName);

        // B3: Ánh xạ danh sách Patient sang DTO
        List<PatientDTO> data = patientPage.getContent().stream()
                .map(patient -> {
                    return new PatientDTO(
                            patient.getPatientCode(),
                            patient.getFullName(),
                            patient.getPhone()
                    );
                })
                .toList();

        // B4: Gán giá trị lớp wrapper và trả về
        PaginationResponse<PatientDTO> paginationResponse = new PaginationResponse<>();
        paginationResponse.setData(data);
        paginationResponse.setCurrentPage(patientPage.getNumber());
        paginationResponse.setTotalPage(patientPage.getTotalPages());
        paginationResponse.setTotalElement(patientPage.getTotalElements());
        return paginationResponse;
    }
}
