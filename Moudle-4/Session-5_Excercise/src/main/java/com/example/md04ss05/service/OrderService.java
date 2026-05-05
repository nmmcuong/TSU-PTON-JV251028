package com.example.md04ss05.service;

import com.example.md04ss05.model.dto.OrderSummary;
import com.example.md04ss05.model.dto.PaginationResponse;
import com.example.md04ss05.model.entity.Order;
import com.example.md04ss05.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByStatus(String status){
        return orderRepository.findByStatus(status);
    }

    public List<Order> getOrdersByCustomerName(String name){
        return orderRepository.findByCustomerNameContaining(name);
    }

    public List<Order> getAllOrdersSorted(String field, String direction){
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();
        return orderRepository.findAll(sort);
    }

    public Page<Order> getOrdersPaged(int page, int size){
        Pageable sortedPage = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return orderRepository.findAll(sortedPage);
    }

    public List<Order> getHighValueOrdersOfCurrentMonth(){
        return orderRepository.findHighValueOrdersOfCurrentMonth();
    }

    public PaginationResponse<OrderSummary> findAllAndPagination(Pageable pageable){
        // truy xuất lớp OrderSummary
        Page<OrderSummary> orderSummaryPage = orderRepository.findAllAndPagination(pageable);

        // tạo wrapper PaginationResponse của lớp OrderSummary
        PaginationResponse<OrderSummary> paginationResponse = new PaginationResponse<>(orderSummaryPage);

        //truyền dữ liệu vào wrapper
        paginationResponse.setCurrentPage(orderSummaryPage.getNumber()); //trang hiện tại - getNumber()
        paginationResponse.setTotalPage(orderSummaryPage.getTotalPages()); // tổng số trang - getTotalPages()
        paginationResponse.setTotalElement(orderSummaryPage.getTotalElements()); // tổng số bản ghi tìm thấy trong Database - getTotalElements()
        return paginationResponse;
    }

    public PaginationResponse<OrderSummary> filterOrders(String status, Double minPrice, Pageable pageable){
        Page<OrderSummary> page = orderRepository.filterOrders(status, minPrice, pageable);

        PaginationResponse<OrderSummary> paginationResponse = new PaginationResponse<>(page);
        paginationResponse.setCurrentPage(page.getNumber());
        paginationResponse.setData(page.getContent());
        paginationResponse.setTotalElement(page.getTotalElements());
        paginationResponse.setTotalPage(page.getTotalPages());
        return paginationResponse;
    }
}
