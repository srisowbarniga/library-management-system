package com.library.management.controller;

import com.library.management.entity.Book;
import com.library.management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchBookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/search-book")
    public String searchBook(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            Model model) {

        List<Book> results = null;

        if (title != null && !title.isEmpty()) {
            results = bookRepository.findByTitleContainingIgnoreCase(title);
        } else if (author != null && !author.isEmpty()) {
            results = bookRepository.findByAuthorContainingIgnoreCase(author);
        } else if (category != null && !category.isEmpty()) {
            results = bookRepository.findByCategoryContainingIgnoreCase(category);
        }

        model.addAttribute("results", results);
        return "search-book";
    }
}