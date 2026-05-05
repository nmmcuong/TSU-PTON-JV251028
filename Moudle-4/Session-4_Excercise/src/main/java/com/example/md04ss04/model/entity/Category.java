package com.example.md04ss04.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Category {
    @Id
    private long id;
    private String categoryName;

    @ManyToMany(mappedBy = "categoryList")
    private List<Book> bookList;
}
