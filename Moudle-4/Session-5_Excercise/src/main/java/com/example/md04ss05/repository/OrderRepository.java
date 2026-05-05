package com.example.md04ss05.repository;

import com.example.md04ss05.model.dto.OrderSummary;
import com.example.md04ss05.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByStatus(@Param("status") String status);

    @Query("SELECT o FROM Order o WHERE o.customerName LIKE %:name%")
    List<Order> findByCustomerNameContaining(@Param("name") String name);

    @Query("SELECT o FROM Order o WHERE " +
            "o.totalPrice > (SELECT AVG(o2.totalPrice) " +
            "FROM Order o2 " +
            "WHERE MONTH(o2.createdAt) = MONTH(NOW))")
    List<Order> findHighValueOrdersOfCurrentMonth();

    // tạo querry ánh xạ vào dữ liệu trong DTO của OrderSummary. Dữ liệu được lấy từ bảng orders
    @Query("SELECT NEW com.example.md04ss05.model.dto.OrderSummary(o.orderCode, o.customerName, o.totalPrice) " +
            "FROM Order o")
    // lấy dữ liệu của OrderSummary về kiểu dữ liệu Page để hiển thị thông tin data
    Page<OrderSummary> findAllAndPagination(Pageable pageable);

    @Query("SELECT NEW com.example.md04ss05.model.dto.OrderSummary(o.orderCode, o.customerName, o.totalPrice) " +
            "FROM Order o " +
            "WHERE (:status IS NULL OR o.status = :status)" +
            "AND (:minPrice IS NULL OR o.totalPrice >= :minPrice)")
    Page<OrderSummary> filterOrders(@Param("status") String status, @Param("minPrice") Double minPrice, Pageable pageable);
}


