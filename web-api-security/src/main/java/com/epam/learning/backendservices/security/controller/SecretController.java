package com.epam.learning.backendservices.security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/secret")
public interface SecretController {

    @GetMapping
    String getSecretPage();

    @PostMapping
    String setSecret(Model model, @RequestParam String secret);

}
