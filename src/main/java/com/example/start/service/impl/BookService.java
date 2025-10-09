package com.example.start.service.impl;

import com.example.start.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Long id);
    List<Book> listAll();
    Book create(String title, String color);
    Book update(Long id, String title, String color);
    void delete(Long id);
    List<Book> filterBooks(String keyword);

    List<Book> filterColors(String keyword);
}