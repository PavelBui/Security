package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.SecretController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Controller
public class SecretControllerImpl implements SecretController {

    @Value("${api.base.uri}")
    private URL apiBaseUrl;

    private String secretValue;

    private UUID uuid;

    public String getSecretPage() {
        return "secret";
    }

    public String setSecret(Model model, @RequestParam String secret) {
        uuid = UUID.randomUUID();
        secretValue = secret;
        URL secretUrl = null;
        try {
            secretUrl = new URL(apiBaseUrl, "/secret/" + uuid);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("url", secretUrl);
        return "secretinfo";
    }

    public String showSecret(Model model, @PathVariable String uuid) {
        if (this.uuid != null && uuid.equals(this.uuid.toString())) {
            model.addAttribute("secret", secretValue);
            this.uuid = null;
            secretValue = "";
            return "secretvalue";
        }
        return "index";
    }

}
