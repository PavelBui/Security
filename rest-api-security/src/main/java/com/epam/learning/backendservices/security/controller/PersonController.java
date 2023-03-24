package com.epam.learning.backendservices.security.controller;

import com.epam.learning.backendservices.security.dto.PersonRequestDto;
import com.epam.learning.backendservices.security.dto.PersonResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@Api(tags = "Person Endpoint")
public interface PersonController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create Person")
    EntityModel<PersonResponseDto> createPerson(@RequestBody PersonRequestDto personRequestDto);

    @PutMapping
    @ApiOperation("Update Person")
    EntityModel<PersonResponseDto> updatePerson(@RequestBody PersonRequestDto personRequestDto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete Person by id")
    @ApiImplicitParam(name = "id", value = "Person id", paramType = "path", required = true)
    ResponseEntity<String> deletePerson(@PathVariable Long id);

    @GetMapping("/{id}")
    @ApiOperation("Get Person by id")
    @ApiImplicitParam(name = "id", value = "Person id", paramType = "path", required = true)
    EntityModel<PersonResponseDto> getPerson(@PathVariable Long id);

    @GetMapping
    @ApiOperation("Get list of all Persons")
    List<EntityModel<PersonResponseDto>> getAllPerson();

}
