package com.example.md04ss05.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
// lớp wrapper để chuẩn hóa dữ liệu trả về cho Frontend
public class PaginationResponse<T>{
    private List<T> data;
    private int totalPage;
    private Long totalElement;
    private int currentPage;

    public PaginationResponse(Page<T> page) {
         this.data = page.getContent();
         this.totalPage = page.getTotalPages();
         this.totalElement = page.getTotalElements();
         this.currentPage = page.getNumber();
    }
}
