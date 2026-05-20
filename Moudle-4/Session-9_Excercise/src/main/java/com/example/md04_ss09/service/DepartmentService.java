package com.example.md04_ss09.service;

import com.example.md04_ss09.model.dto.DepartmentDTO;
import com.example.md04_ss09.model.entity.Department;
import com.example.md04_ss09.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(DepartmentDTO departmentDTO) {
        Department newDepartment = new Department();
        newDepartment.setName(departmentDTO.getName());
        newDepartment.setDescription(departmentDTO.getDescription());
        return departmentRepository.save(newDepartment);
    }
}
