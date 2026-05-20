package com.example.md04_ss09.controller;

import com.example.md04_ss09.model.dto.DepartmentDTO;
import com.example.md04_ss09.model.entity.Department;
import com.example.md04_ss09.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentDTO));
    }
}
