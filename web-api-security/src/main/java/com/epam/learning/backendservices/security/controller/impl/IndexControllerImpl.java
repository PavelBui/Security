package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.IndexController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class IndexControllerImpl implements IndexController {

    public String homePage(Model model) {
        model.addAttribute("title", "Index Page");
        return "index";
    }

}
