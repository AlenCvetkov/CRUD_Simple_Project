package com.example.start.web;

import com.example.start.model.Book;
import com.example.start.service.impl.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController( BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping
    public String getAllBooks(Model model){
        model.addAttribute("books", bookService.listAll());
        return "list";
    }
    @PostMapping("/createbook")
    public String create(@RequestParam String title,  @RequestParam String color){
        bookService.create(title,color);
        return "redirect:/books";
    }

    @PostMapping("/updatebook/{id}")
    public String update( @PathVariable Long id, @RequestParam String title, @RequestParam String color){
        bookService.update(id,title,color);
        return "redirect:/books";
    }

    @PostMapping("/deletebook/{id}")
    public String delete( @PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/filter")
    public String filterTitle(@RequestParam String keyword, Model model){
        List<Book> results = bookService.filterColors(keyword);
        model.addAttribute("books", results);
        model.addAttribute("noResultsT", results.isEmpty());
        return "list";
    }

    @GetMapping("/filtercolor")
    public String filterColor(@RequestParam String keyword, Model model){
        List<Book> results = bookService.filterColors(keyword);
        model.addAttribute("books", results);
        model.addAttribute("noResultsC", results.isEmpty());
        return "list";
    }
}
