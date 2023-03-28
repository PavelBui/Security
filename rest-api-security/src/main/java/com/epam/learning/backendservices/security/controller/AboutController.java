package com.epam.learning.backendservices.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/about")
@Api(tags = "About Endpoint")
public interface AboutController {

    @GetMapping
    @ApiOperation("Get information about API")
    String getAboutInfo();
}
