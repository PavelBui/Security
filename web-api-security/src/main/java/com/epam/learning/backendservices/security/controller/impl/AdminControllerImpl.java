package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.AdminController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AdminControllerImpl implements AdminController {

    public String adminPage(Model model) {
        model.addAttribute("title", "Admin Page");
        return "admin";
    }
}
