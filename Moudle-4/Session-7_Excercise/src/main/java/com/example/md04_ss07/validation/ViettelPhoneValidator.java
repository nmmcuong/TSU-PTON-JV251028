package com.example.md04_ss07.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ViettelPhoneValidator implements ConstraintValidator<ViettelPhone, String> {
    private static final String PHONE_REGEX = "^0(3[2-9]|86|9[678])\\d{7}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty()){
            return true;
        }
        return value.matches(PHONE_REGEX);
    }
}
