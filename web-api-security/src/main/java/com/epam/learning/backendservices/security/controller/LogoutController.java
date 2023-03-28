package com.epam.learning.backendservices.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logoutSuccess")
public interface LogoutController {

    @GetMapping
    String logoutPage();
}
