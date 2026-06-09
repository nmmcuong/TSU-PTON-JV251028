package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
    // Tìm kiếm tương đối, không phân biệt hoa thường trên cả tên khóa học và giảng viên
    List<Course> findByCourseNameContainingIgnoreCaseOrInstructorContainingIgnoreCase(String courseName, String instructor);
    Page<Course> findByCourseNameContainingIgnoreCaseOrInstructorContainingIgnoreCase(
            String courseName, String instructor, Pageable pageable);
}