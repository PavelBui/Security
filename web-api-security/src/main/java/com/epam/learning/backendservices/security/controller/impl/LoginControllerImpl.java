package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.LoginController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginControllerImpl implements LoginController {

    public String loginPage(final ModelMap model, @RequestParam("error") final Optional<String> error) {
        error.ifPresent(e -> model.addAttribute("error", e));
        return "login";
    }

}
