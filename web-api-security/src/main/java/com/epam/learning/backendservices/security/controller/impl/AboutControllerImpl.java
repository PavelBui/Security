package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.AboutController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AboutControllerImpl implements AboutController {

    public String aboutPage(Model model) {
        model.addAttribute("title", "About Page");
        return "about";
    }
}
