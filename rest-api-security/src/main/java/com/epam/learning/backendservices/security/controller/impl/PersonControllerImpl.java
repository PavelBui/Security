package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.PersonController;
import com.epam.learning.backendservices.security.dto.PersonRequestDto;
import com.epam.learning.backendservices.security.dto.PersonResponseDto;
import com.epam.learning.backendservices.security.exeption.PersonNotFoundException;
import com.epam.learning.backendservices.security.model.Person;
import com.epam.learning.backendservices.security.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class PersonControllerImpl implements PersonController {

    private PersonService personService;
    private Converter<Person, PersonResponseDto> personToPersonResponseDtoConverter;
    private Converter<PersonRequestDto, Person> personRequestDtoToPersonConverter;

    public EntityModel<PersonResponseDto> createPerson(@RequestBody PersonRequestDto personRequestDto) {
        Person person = personService.createPerson(personRequestDtoToPersonConverter.convert(personRequestDto));
        return toModel(personToPersonResponseDtoConverter.convert(person));
    }

    public EntityModel<PersonResponseDto> updatePerson(@RequestBody PersonRequestDto personRequestDto) {
        Person person = personService.updatePerson(personRequestDtoToPersonConverter.convert(personRequestDto));
        return toModel(personToPersonResponseDtoConverter.convert(person));
    }

    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    public EntityModel<PersonResponseDto> getPerson(@PathVariable Long id) {
        Person person = personService.getPerson(id).orElseThrow(() -> new PersonNotFoundException(id));
        return toModel(personToPersonResponseDtoConverter.convert(person));
    }

    public List<EntityModel<PersonResponseDto>> getAllPerson() {
        return personService.getAllPerson()
                .stream()
                .map(person -> personToPersonResponseDtoConverter.convert(person))
                .map(PersonControllerImpl::toModel)
                .collect(Collectors.toList());
    }

    private static EntityModel<PersonResponseDto> toModel(PersonResponseDto response) {
        return EntityModel.of(response,
                linkTo(methodOn(PersonControllerImpl.class).getPerson(response.getId())).withSelfRel(),
                linkTo(methodOn(PersonControllerImpl.class).getAllPerson()).withRel("getAllPersons"),
                linkTo(methodOn(PersonControllerImpl.class).deletePerson(response.getId())).withRel("deletePerson"),
                linkTo(methodOn(PersonControllerImpl.class).createPerson(new PersonRequestDto())).withRel("createPerson"),
                linkTo(methodOn(PersonControllerImpl.class).updatePerson(new PersonRequestDto())).withRel("updatePerson")
        );
    }
}
