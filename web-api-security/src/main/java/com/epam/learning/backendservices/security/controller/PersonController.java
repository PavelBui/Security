package com.epam.learning.backendservices.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@Api(tags = "Person Endpoint")
public interface PersonController {

    @GetMapping
    @ApiOperation("Get list of all Persons")
    String getAllPerson(Model model);

}
