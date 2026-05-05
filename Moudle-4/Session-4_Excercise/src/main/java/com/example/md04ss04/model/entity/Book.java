package com.example.md04ss04.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id") // khóa ngoại của author
    @JsonIgnoreProperties("books") // chỉ hiển thị duy nhất 1 sách, tránh bị vào vòng lặp vô hạn
    private Author author;

    @ManyToMany //Bảng trung gian giữa Book và Category
    @JoinTable(
            name = "book_category", // tên bảng
            joinColumns = @JoinColumn(name = "book_id"), // khóa ngoại của book
            inverseJoinColumns = @JoinColumn(name = "category_id") // khóa ngoại của category
    )
    private List<Category> categoryList;
}
