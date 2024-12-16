package com.example.service;
import java.util.List;
import java.util.Optional;

import com.example.entity.Book;

public interface BookService {

    // Create a new book
    Book createBook(Book book);

    // Get all books
    List<Book> getAllBooks();

    // Get a book by id
    Optional<Book> getBookById(String id);

    // Update a book
    Book updateBook(String id, Book bookDetails);

    // Delete a book
    void deleteBook(String id);
}

