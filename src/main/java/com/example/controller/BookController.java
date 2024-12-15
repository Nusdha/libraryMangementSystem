package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.repo.BookRepo;
import com.example.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
    
    @RestController
    @RequestMapping("/api/books")
    public class BookController {
    
        @Autowired
        private BookRepo bookRepository;
        @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        Optional<Book> book = bookRepository.findById(id);

        return (() book).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Update a book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setYearPublished(bookDetails.getYearPublished());
        
        return bookRepository.save(book);
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        
        bookRepository.delete(book);
    }
}

