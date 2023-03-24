package com.epam.learning.backendservices.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/index")
@Api(tags = "Index Endpoint")
public interface IndexController {

    @GetMapping
    @ApiOperation("Get main page")
    String homePage(Model model);
}
