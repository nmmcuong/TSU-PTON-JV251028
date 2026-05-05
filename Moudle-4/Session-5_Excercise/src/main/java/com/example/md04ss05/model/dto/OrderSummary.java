package com.example.md04ss05.model.dto;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// tạo lớp DTO lọc dữ liệu cần truy xuất
public class OrderSummary {
    private String orderCode;
    private String customerName;
    private Double totalPrice;
}
