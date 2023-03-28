package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.SecretController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class SecretControllerImpl implements SecretController {

    @Value("${api.base.uri}")
    private URL apiBaseUrl;

    private Map<UUID, String> secretMap = new HashMap<>();

    public String getSecretPage() {
        return "secret";
    }

    public String setSecret(Model model, @RequestParam String secret) {
        UUID uuid = UUID.randomUUID();
        secretMap.put(uuid, secret);
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
        UUID inputUuid = UUID.fromString(uuid);
        String secretValue = secretMap.get(inputUuid);
        if (secretValue != null) {
            model.addAttribute("secret", secretValue);
            secretMap.remove(inputUuid);
            return "secretvalue";
        }
        return "index";
    }

}
