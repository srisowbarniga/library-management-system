package com.library.management.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@RequestParam(required = false) String role, HttpSession session) {
        if (role != null) {
            session.setAttribute("role", role);
        }
        return "index";
    }
}