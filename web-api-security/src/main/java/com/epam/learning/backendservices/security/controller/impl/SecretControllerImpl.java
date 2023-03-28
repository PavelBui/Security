package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.SecretController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Controller
public class SecretControllerImpl implements SecretController {

    @Value("${api.base.uri}")
    private URL apiBaseUrl;

    public String getSecretPage() {
        return "secret";
    }

    public String setSecret(Model model, @RequestParam String secret) {
        UUID uuid = UUID.randomUUID();
        URL url = null;
        try {
            url = new URL(apiBaseUrl, "/secret/" + uuid);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("url", url);
        return "secretinfo";
    }
}
