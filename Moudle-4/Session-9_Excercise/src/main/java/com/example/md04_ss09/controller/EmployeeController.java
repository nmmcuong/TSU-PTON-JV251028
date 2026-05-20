package com.example.md04_ss09.controller;

import com.example.md04_ss09.model.dto.EmployeeDTO;
import com.example.md04_ss09.model.entity.Employee;
import com.example.md04_ss09.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employeeDTO));
    }

    @PutMapping("/{id}/avatar")
    public ResponseEntity<?> addAvatar(@RequestPart("avatar")MultipartFile file, @PathVariable Integer id){
        Employee updatedEmployee = employeeService.updateAvatarEmployee(file, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
    }
}
