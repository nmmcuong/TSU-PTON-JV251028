package com.example.md04_ss09.repository;

import com.example.md04_ss09.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
