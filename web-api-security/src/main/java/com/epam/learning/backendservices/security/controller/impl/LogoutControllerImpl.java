package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.LogoutController;
import org.springframework.stereotype.Controller;

@Controller
public class LogoutControllerImpl implements LogoutController {

    public String logoutPage() {
        return "logout";
    }
}
