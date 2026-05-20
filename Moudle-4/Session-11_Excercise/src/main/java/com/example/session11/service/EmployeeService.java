package com.example.session11.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.session11.exception.DuplicateResourceException;
import com.example.session11.exception.ResourceNotFoundException;
import com.example.session11.model.Employee;
import com.example.session11.model.request.EmployeeCreateDTO;
import com.example.session11.model.response.EmployeeResponse;
import com.example.session11.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional // Bắt buộc để Rollback nếu có lỗi Upload
    public EmployeeResponse createEmployee(EmployeeCreateDTO request) {

        // 1. Validate Nghiệp vụ
        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email này đã tồn tại trong hệ thống.");
        }

        // 2. Map DTO sang Entity và LƯU TRƯỚC VÀO DB
        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());

        // Lưu tạm vào DB (Nếu lát nữa upload lỗi, @Transactional sẽ tự xóa record này)
        employee = employeeRepository.save(employee);

        // 3. Xử lý File và giả lập Upload Cloudinary
        MultipartFile file = request.getAvatarFile();
        String avatarUrl = null;

        if (file != null && !file.isEmpty()) {
            // Giả lập logic kiểm tra định dạng
            String filename = file.getOriginalFilename();
            if (filename != null && !filename.matches(".*\\.(jpg|jpeg|png)$")) {
                throw new IllegalArgumentException("Chỉ chấp nhận file ảnh định dạng JPG/PNG");
            }

            // Giả lập văng lỗi khi tên file chứa chữ "error" để test chức năng Rollback
            if (filename != null && filename.toLowerCase().contains("error")) {
                throw new RuntimeException("Giả lập lỗi Cloudinary SDK sập! Dữ liệu DB sẽ bị Rollback.");
            }

            // Mô phỏng URL trả về từ Cloudinary
            avatarUrl = "https://res.cloudinary.com/enterprise/image/upload/v1/" + UUID.randomUUID() + ".jpg";

            // Cập nhật URL vào Entity
            employee.setAvatarUrl(avatarUrl);
            // JPA Dirty Checking tự động cập nhật lệnh UPDATE xuống DB lúc kết thúc
            // Transaction
        }

        // 4. Trả về DTO
        return new EmployeeResponse(
                employee.getId(),
                employee.getFullName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getAvatarUrl());
    }

    @Transactional
    public EmployeeResponse updateEmployee(Long id, EmployeeCreateDTO request) {

        // 1. Kiểm tra Nhân viên có tồn tại không?
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy nhân viên với ID: " + id));

        // 2. NGHIỆP VỤ CAO CẤP: Kiểm tra trùng Email
        // Chỉ check trùng khi Email gửi lên KHÁC với Email hiện tại của chính nhân viên
        // đó
        if (!existingEmployee.getEmail().equalsIgnoreCase(request.getEmail()) &&
                employeeRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email này đã được sử dụng bởi một nhân viên khác.");
        }

        // 3. Cập nhật thông tin Text
        existingEmployee.setFullName(request.getFullName());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setDepartment(request.getDepartment());

        // 4. Xử lý File (Có điều kiện)
        MultipartFile file = request.getAvatarFile();
        if (file != null && !file.isEmpty()) {

            // Validate định dạng
            String filename = file.getOriginalFilename();
            if (filename != null && !filename.matches(".*\\.(jpg|jpeg|png)$")) {
                throw new IllegalArgumentException("Chỉ chấp nhận file ảnh định dạng JPG/PNG");
            }

            // Giả lập logic Upload Cloudinary và lấy URL mới
            String newAvatarUrl = "https://res.cloudinary.com/enterprise/image/upload/v2/" + UUID.randomUUID() + ".jpg";

            // Cập nhật Avatar mới
            existingEmployee.setAvatarUrl(newAvatarUrl);
        }
        // NẾU file == null, ta không làm gì cả -> existingEmployee giữ nguyên URL cũ.

        // Bỏ qua hàm .save() vì JPA Dirty Checking sẽ tự động lưu khi kết thúc
        // Transaction

        // 5. Trả về Response
        return new EmployeeResponse(
                existingEmployee.getId(),
                existingEmployee.getFullName(),
                existingEmployee.getEmail(),
                existingEmployee.getDepartment(),
                existingEmployee.getAvatarUrl());
    }
}
