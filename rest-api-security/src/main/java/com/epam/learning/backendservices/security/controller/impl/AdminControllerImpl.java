package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.AdminController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminControllerImpl implements AdminController {

    public String getSecretInfo() {
        return "Some secret info for admins only";
    }
}
