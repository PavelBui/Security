package com.epam.learning.backendservices.security.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String home(Model model) {
        model.addAttribute("title", "Index Page");
        return "index";
    }

}
