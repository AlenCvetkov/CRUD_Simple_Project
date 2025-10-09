package com.example.start.service.impl;

import com.example.start.model.Book;
import com.example.start.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Optional<Book> findById(Long id) {
        return  bookRepository.findById(id);
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(String title, String color) {
        return  bookRepository.save(new Book(title,color));
    }

    @Override
    public Book update(Long id, String title, String color) {
      Optional<Book> b =  this.findById(id);
      if (b.isPresent()) {
          Book book = b.get();
          book.setTitle(title);
          book.setColor(color);
      }
//         b.setTitle(title);
//         b.get().setColor(color);
        if(b.isPresent()) {
            return this.bookRepository.save(b.get());
        } else {
            throw new RuntimeException("Book not found");
        }

    }

    @Override
    public void delete(Long id) {
        Optional<Book> b =  this.findById(id);
        this.bookRepository.delete(b.get());
    }

    @Override
    public List<Book> filterBooks(String keyword) {
        return bookRepository.findBookByTitleContainingIgnoreCase(keyword);

    }

    @Override
    public List<Book> filterColors(String keyword) {
        return bookRepository.findBookByColorContainingIgnoreCase(keyword);
    }
}
