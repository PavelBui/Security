package com.epam.learning.backendservices.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Api(tags = "Admin Endpoint")
public interface AdminController {

    @GetMapping
    @ApiOperation("Get secret information")
    String getSecretInfo();
}
