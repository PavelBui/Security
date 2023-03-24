package com.epam.learning.backendservices.security.converter;

import com.epam.learning.backendservices.security.dto.PersonRequestDto;
import com.epam.learning.backendservices.security.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonRequestDtoToPersonConverter implements Converter<PersonRequestDto, Person> {

    @Override
    public Person convert(PersonRequestDto personRequestDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personRequestDto, person);
        person.setBirthday(LocalDate.parse(personRequestDto.getBirthday()));
        return person;
    }

}
