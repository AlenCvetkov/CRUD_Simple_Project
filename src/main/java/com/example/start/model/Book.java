package com.example.start.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.internal.UserTypeSqlTypeAdapter;
import org.springframework.web.service.annotation.GetExchange;

import javax.print.DocFlavor;

@Getter
@Entity
@Data
public class Book {

    public Book(String title, String color){
        this.title=title;
        this.color=color;
    }
    public Book() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String title;

    private String color;

    public void setTitle(String title) {
        this.title = title;
    }
    public void setColor(String color){
        this.color=color;
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }
}
