package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.InfoController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoControllerImpl implements InfoController {

    public String getInfo() {
        return "Some info about application";
    }
}
