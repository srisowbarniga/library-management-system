package com.library.management.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute("role")
    public String role(HttpSession session) {
        Object role = session.getAttribute("role");
        return role != null ? role.toString() : "student";
    }
}