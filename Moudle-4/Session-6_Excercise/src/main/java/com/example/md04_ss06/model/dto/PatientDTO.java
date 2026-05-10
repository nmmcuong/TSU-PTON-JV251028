package com.example.md04_ss06.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientDTO { // các trường muốn in ra data
    private String patientCode;
    private String fullName;
    private String phone;
}
