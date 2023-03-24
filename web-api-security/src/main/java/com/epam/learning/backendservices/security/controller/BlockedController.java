package com.epam.learning.backendservices.security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blocked")
public interface BlockedController {

    @GetMapping
    String blockedPage(Model model);
}
