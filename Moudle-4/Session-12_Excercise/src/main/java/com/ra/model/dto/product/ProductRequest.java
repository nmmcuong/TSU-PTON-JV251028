package com.ra.model.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    @NotBlank(message = "Nhập tên sản phẩm")
    private String name;
    private String description;
    @NotNull(message = "Nhập giá sản phẩm")
    private Double price;
    @NotBlank(message = "Nhập kích cỡ sản phẩm")
    private String size;
    private String toppings;
}
