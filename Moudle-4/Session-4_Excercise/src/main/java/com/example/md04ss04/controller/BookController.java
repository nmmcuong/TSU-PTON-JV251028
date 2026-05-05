package com.example.md04ss04.controller;

import com.example.md04ss04.model.dto.BookRequest;
import com.example.md04ss04.model.entity.Author;
import com.example.md04ss04.model.entity.Book;
import com.example.md04ss04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest){
        Author author = bookService.getAuthorById(bookRequest.getAuthorId());
        if (author == null) {
            return new ResponseEntity<>("Tác giả không tồn tại", HttpStatus.BAD_REQUEST);
        }else{
            Book newBook = new Book();
            newBook.setAuthor(author);
            newBook.setTitle(bookRequest.getTitle());
            newBook.setPrice(bookRequest.getPrice());
            return new ResponseEntity<>(bookService.addBook(newBook), HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> allBooks(){
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBookById(@PathVariable long id){
        Book foundBook = bookService.getBookById(id);
        if (foundBook == null) {
            return ResponseEntity.status(404).body("Sách có mã " + id + " không tồn tại");
        }else{
            return ResponseEntity.status(200).body(foundBook);
        }
    }
}
