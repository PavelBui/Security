package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.PersonController;
import com.epam.learning.backendservices.security.dto.PersonDto;
import com.epam.learning.backendservices.security.model.Person;
import com.epam.learning.backendservices.security.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class PersonControllerImpl implements PersonController {

    private PersonService personService;
    private Converter<Person, PersonDto> personToPersonDtoConverter;

    public String getAllPerson(Model model) {
        List<PersonDto> personDtoList = personService.getAllPerson()
                .stream()
                .map(person -> personToPersonDtoConverter.convert(person))
                .collect(Collectors.toList());
        model.addAttribute("persons", personDtoList);
        return "person";
    }

}
