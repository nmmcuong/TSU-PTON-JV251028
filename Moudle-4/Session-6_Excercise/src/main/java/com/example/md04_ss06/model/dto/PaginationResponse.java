package com.example.md04_ss06.model.dto;

import com.example.md04_ss06.model.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponse<T> { // wrapper trả về dữ liệu
    private List<T> data;
    private Integer totalPage;
    private Long totalElement;
    private Integer currentPage;
}
