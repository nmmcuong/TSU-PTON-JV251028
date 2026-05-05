package com.example.md04ss05.controller;

import com.example.md04ss05.model.dto.OrderSummary;
import com.example.md04ss05.model.dto.PaginationResponse;
import com.example.md04ss05.model.entity.Order;
import com.example.md04ss05.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/searchStatus")
    public ResponseEntity<?> searchOrdersByStatus(@RequestParam String status){
        List<Order> orderList = orderService.getOrdersByStatus(status);
        if(orderList.isEmpty()){
            return ResponseEntity.status(404).body("Danh sách trống");
        }else{
            return ResponseEntity.status(201).body(orderList);
        }
    }

    @GetMapping("/searchByCustomer")
    public ResponseEntity<?> searchOrdersByCustomerName(@RequestParam String name){
        List<Order> orderList = orderService.getOrdersByCustomerName(name);
        if(orderList.isEmpty()){
            return ResponseEntity.status(404).body("Danh sách trống");
        }else{
            return ResponseEntity.status(201).body(orderList);
        }
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Order>> searchAllOrdersSorted(@RequestParam String sortBy, @RequestParam String dir){
        List<Order> sortedOrderList = orderService.getAllOrdersSorted(sortBy, dir);
        return ResponseEntity.status(201).body(sortedOrderList);
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<Order>> searchOrdersPaged(@RequestParam Integer page, @RequestParam Integer size){
        Page<Order> sortedPageList = orderService.getOrdersPaged(page, size);
        return ResponseEntity.status(201).body(sortedPageList);
    }

    @GetMapping("/high-value")
    public ResponseEntity<List<Order>> searchHighValueOrdersOfCurrentMonth(){
        return ResponseEntity.status(201).body(orderService.getHighValueOrdersOfCurrentMonth());
    }

    @GetMapping("/findAllAndSearch")
    public ResponseEntity<PaginationResponse<OrderSummary>> findAllAndSearch(@RequestParam("page") int page, @RequestParam("size") int size){
        //gọi Page
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(201).body(orderService.findAllAndPagination(pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<PaginationResponse<OrderSummary>> getFilterOrders(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String dir){

        Sort sort = dir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return ResponseEntity.status(201).body(orderService.filterOrders(status, minPrice, pageable));
    }
}
