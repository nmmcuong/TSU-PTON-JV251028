package com.example.md04ss04.service;

import com.example.md04ss04.model.entity.Author;
import com.example.md04ss04.model.entity.Book;
import com.example.md04ss04.repository.AuthorRepository;
import com.example.md04ss04.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public Author getAuthorById(long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(long id){
        return bookRepository.findById(id).orElse(null);
    }
}
