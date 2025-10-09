package com.example.start.repo;

import com.example.start.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByTitleContainingIgnoreCase(String title);
    List<Book> findBookByColorContainingIgnoreCase(String color);
}
