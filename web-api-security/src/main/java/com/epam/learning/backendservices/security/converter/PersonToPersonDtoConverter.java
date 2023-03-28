package com.epam.learning.backendservices.security.converter;

import com.epam.learning.backendservices.security.dto.PersonDto;
import com.epam.learning.backendservices.security.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConverter implements Converter<Person, PersonDto> {

    @Override
    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        personDto.setBirthday(person.getBirthday().toString());
        return personDto;
    }

}
