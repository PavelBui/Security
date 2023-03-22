package com.epam.learning.backendservices.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/info")
@Api(tags = "Info Endpoint")
public interface InfoController {

    @GetMapping
    @ApiOperation("Get information")
    String getInfo();
}
