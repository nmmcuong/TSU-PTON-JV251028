package com.example.employee.repository;


import com.example.session02.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // [Bài tập 2] Đánh dấu tầng Repository

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        // Tạo dữ liệu giả
        employees.add(new Employee(1, "Nguyen Van A", "a@gmail.com", "IT"));
        employees.add(new Employee(2, "Tran Thi B", "b@gmail.com", "HR"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Optional<Employee> findById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void save(Employee employee) {
        employees.add(employee);
    }

    public void update(int id, Employee newInfo) {
        findById(id).ifPresent(e -> {
            e.setFullName(newInfo.getFullName());
            e.setEmail(newInfo.getEmail());
            e.setDepartment(newInfo.getDepartment());
        });
    }

    public boolean delete(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
