package com.example.md04_ss08.controller;
import com.example.md04_ss08.exception.StudentNotFoundException;
import com.example.md04_ss08.model.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    public StudentController(){
        studentList.add(new Student(1, "Nguyen Van A"));
        studentList.add(new Student(2, "Tran Van B"));
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        for (Student student : studentList){
            if(student.getId() == id){
                return student;
            }
        }
        throw new StudentNotFoundException("Không tìm thấy sinh viên có id là: " + id);
    }
}
