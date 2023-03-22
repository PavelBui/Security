package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.AboutController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutControllerImpl implements AboutController {

    public String getAboutInfo() {
        return "Some open info about API";
    }
}
