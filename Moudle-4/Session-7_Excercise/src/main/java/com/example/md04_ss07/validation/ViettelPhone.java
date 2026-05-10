package com.example.md04_ss07.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ViettelPhoneValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViettelPhone {
    String message() default "Số điện thoại không thuộc nhà mạng Viettel hoặc sai định dạng";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
