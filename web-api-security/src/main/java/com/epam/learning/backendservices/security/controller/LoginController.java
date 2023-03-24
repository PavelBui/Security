package com.epam.learning.backendservices.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public interface LoginController {

    @GetMapping
    String loginPage();
}
