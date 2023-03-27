package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.SecretController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class SecretControllerImpl implements SecretController {

    public String getSecretPage() {
        return "secret";
    }

    public String setSecret(Model model, @RequestParam String secret) {
        UUID uuid = UUID.randomUUID();
        String url = "http://localhost8080/secret/" + uuid;
        model.addAttribute("url", url);
        return "secretinfo";
    }
}
