package com.example.md04_ss09.service;

import com.example.md04_ss09.common.exception.DuplicateException;
import com.example.md04_ss09.common.exception.ResourceNotFoundException;
import com.example.md04_ss09.model.dto.EmployeeDTO;
import com.example.md04_ss09.model.entity.Department;
import com.example.md04_ss09.model.entity.Employee;
import com.example.md04_ss09.repository.DepartmentRepository;
import com.example.md04_ss09.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // tạo đối tượng Path trỏ đến thư mục "uploads" - chuyển đổi thành đường dẫn tuyệt đối - loại bỏ các ký hiệu dư thừa
    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();

    public Employee addEmployee(EmployeeDTO employeeDTO){
        // kiểm tra sự tồn tại của phòng ban
        Department department = departmentRepository.findById(employeeDTO.getDepartment_id()).orElse(null);
        if (department == null){
            throw new ResourceNotFoundException("Phòng ban không tồn tại");
        }

        // kiểm tra sự tồn tại của email
        Employee emailExist = employeeRepository.findByEmail(employeeDTO.getEmail()).orElse(null);
        if(emailExist != null){
            throw new DuplicateException("Email đã tồn tại");
        }

        // thêm mới nhân viên thông qua DTO
        Employee newEmployee = new Employee();
        newEmployee.setFullName(employeeDTO.getFullName());
        newEmployee.setEmail(employeeDTO.getEmail());
        newEmployee.setPhone(employeeDTO.getPhone());
        newEmployee.setSalary(employeeDTO.getSalary());
        newEmployee.setDepartment(department);
        return employeeRepository.save(newEmployee);
    }

    // tạo thư mục lưu trữ file
    public EmployeeService(){
        try {
            Files.createDirectories(this.fileStorageLocation);
        }catch (IOException e){
            throw new RuntimeException("Không thể tạo thư mục tải lên", e);
        }
    }

    // cập nhật avatar cho nhân viên
    public Employee updateAvatarEmployee(MultipartFile file, Integer id){

        // kiểm tra sự tồn tại của nhân viên muốn cập nhật
        Employee updateEmployee = employeeRepository.findById(id).orElse(null);
        if(updateEmployee == null){
            throw new ResourceNotFoundException("Nhân viên không tồn tại");
        }

        // kiểm tra file có rỗng không
        if (file.isEmpty()){
            throw new IllegalArgumentException("File không được để trống");
        }

        // kiểm tra loại file được tải lên
        String contentType = file.getContentType();
        if(contentType == null || (!contentType.equalsIgnoreCase("image/jpeg") && !contentType.equalsIgnoreCase("image/png"))){
            throw new IllegalArgumentException("Chỉ nhận file ảnh đuôi jpeg/jpg/png");
        }


        try {
            // tạo tên ngẫu nhiên cho file thay vì tên gốc
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String fileName = UUID.randomUUID() + "." + extension;

            // xác định địa chỉ lưu file - nối với tên file tạo đường dẫn
            Path targetLocation = this.fileStorageLocation.resolve(fileName);

            // nhận file của người dùng upload lên- địa chỉ lưu file - thay thế nếu có file cũ đã tồn tại
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            updateEmployee.setAvatarUrl(fileName);
            return employeeRepository.save(updateEmployee);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi lưu trữ file",e);
        }
    }
}
