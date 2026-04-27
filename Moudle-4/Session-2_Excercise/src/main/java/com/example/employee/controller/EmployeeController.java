package com.example.employee.controller;


import com.example.session02.model.dto.EmployeeFilter;
import com.example.session02.model.entity.Employee;
import com.example.session02.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // [Bài tập 3] Thay thế @Controller
@RequestMapping("/api/employees") // [Bài tập 3] Định nghĩa tiền tố chung

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // [Bài tập 3 + 6] Lấy danh sách + ResponseEntity
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // [Bài tập 4] Lấy chi tiết dùng @PathVariable
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // [Bài tập 4] Tìm kiếm dùng @RequestParam
    // URL: /api/employees/search?name=Nguyen
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByName(name));
    }

    // [Bài tập 4] Lọc nâng cao dùng @ModelAttribute
    // URL: /api/employees/filter?name=A&department=IT
    @GetMapping("/filter")
    public ResponseEntity<String> filterEmployee(@ModelAttribute EmployeeFilter filter) {
        // Demo nhận dữ liệu
        return ResponseEntity.ok("Đang lọc theo tên: " + filter.getName() +
                " và phòng ban: " + filter.getDepartment());
    }

    // [Bài tập 5 + 6] Thêm mới dùng @PostMapping, @RequestBody và Status 201
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmp = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmp);
    }

    // [Bài tập 5] Cập nhật dùng @PutMapping
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmp = employeeService.updateEmployee(id, employee);
        if (updatedEmp != null) {
            return ResponseEntity.ok(updatedEmp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // [Bài tập 5 + 6] Xóa dùng @DeleteMapping và Status 204/200
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.ok("Xóa thành công nhân viên ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy nhân viên để xóa");
        }
    }
}
