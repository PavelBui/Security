package com.epam.learning.backendservices.security.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequestMapping("/login")
public interface LoginController {

    @GetMapping
    String loginPage(final ModelMap model, @RequestParam("error") final Optional<String> error);

}
