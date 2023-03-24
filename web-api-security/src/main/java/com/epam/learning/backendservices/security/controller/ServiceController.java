package com.epam.learning.backendservices.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/subscription")
@Api(tags = "Subscription Endpoint")
public interface ServiceController {

    @GetMapping
    @ApiOperation("Get list of all Subscriptions")
    String getAllSubscription(Model model);
}
