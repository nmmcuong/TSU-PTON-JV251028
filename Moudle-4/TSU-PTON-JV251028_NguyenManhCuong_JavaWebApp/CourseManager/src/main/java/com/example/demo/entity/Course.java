package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên khóa học không được trống")
    @Size(min = 5, max = 100, message = "Tên khóa học phải từ 5 đến 100 ký tự")
    private String courseName;

    @NotBlank(message = "Giảng viên không được trống")
    private String instructor;

    @NotNull(message = "Thời lượng không được để trống")
    @Min(value = 1, message = "Thời lượng phải > 0")
    @Max(value = 500, message = "Tối đa 500 giờ")
    private Integer duration;

    private String thumbnail;

    public Course() {
    }

    public Course(Long id, String courseName, String instructor, Integer duration, String thumbnail) {
        this.id = id;
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}