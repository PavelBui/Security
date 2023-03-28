package com.epam.learning.backendservices.security.controller;

import com.epam.learning.backendservices.security.dto.SubscriptionRequestDto;
import com.epam.learning.backendservices.security.dto.SubscriptionResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subscription")
@Api(tags = "Subscription Endpoint")
public interface ServiceController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create Subscription")
    EntityModel<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto);

    @PutMapping
    @ApiOperation("Update Subscription")
    EntityModel<SubscriptionResponseDto> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete Subscription by id")
    @ApiImplicitParam(name = "id", value = "Subscription id", paramType = "path", required = true)
    ResponseEntity<String> deleteSubscription(@PathVariable Long id);

    @GetMapping("/{id}")
    @ApiOperation("Get Subscription by id")
    @ApiImplicitParam(name = "id", value = "Subscription id", paramType = "path", required = true)
    EntityModel<SubscriptionResponseDto> getSubscription(@PathVariable Long id);

    @GetMapping
    @ApiOperation("Get list of all Subscriptions")
    List<EntityModel<SubscriptionResponseDto>> getAllSubscription();
}
