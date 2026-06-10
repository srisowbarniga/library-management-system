package com.library.management.controller;

import com.library.management.entity.IssueBook;
import com.library.management.repository.IssueBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IssueBookController {

    @Autowired
    private IssueBookRepository issueBookRepository;

    @GetMapping("/issue-books")
    public String issueBooks(Model model) {

        model.addAttribute("issueBooks", issueBookRepository.findAll());

        return "issue-books";
    }
}