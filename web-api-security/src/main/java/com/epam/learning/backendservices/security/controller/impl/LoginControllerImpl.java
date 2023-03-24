package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.LoginController;
import org.springframework.stereotype.Controller;

@Controller
public class LoginControllerImpl implements LoginController {

    public String loginPage() {
        return "login";
    }
}
