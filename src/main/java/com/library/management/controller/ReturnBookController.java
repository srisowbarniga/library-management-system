package com.library.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReturnBookController {

    @GetMapping("/return-books")
    public String returnBooks() {
        return "return-books";
    }
}