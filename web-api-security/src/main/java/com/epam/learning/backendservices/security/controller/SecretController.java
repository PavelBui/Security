package com.epam.learning.backendservices.security.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/secret")
public interface SecretController {

    @GetMapping
    String getSecretPage();

    @PostMapping
    String setSecret(Model model, @RequestParam String secret);

    @GetMapping("/{uuid}")
    String showSecret(Model model, @PathVariable String uuid);

}
