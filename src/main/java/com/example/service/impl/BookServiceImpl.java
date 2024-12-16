package com.example.service.impl;
import com.example.entity.Book;
import com.example.repo.BookRepo;
import com.example.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    // Create a new book
    @Override
    public com.example.entity.Book createBook(Book book) {
        return bookRepo.save(book);
    }

    // Get all books
    @Override
    public List<com.example.entity.Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // Get a book by id
    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepo.findById(id);
    }

    // Update a book
    @Override
    public Book updateBook(String id, Book bookDetails) {
        // Check if book exists
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Update the book fields
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setYearPublished(bookDetails.getYearPublished());

        return bookRepo.save(book);
    }

    // Delete a book
    @Override
    public void deleteBook(String id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepo.delete(book);
    }
}
