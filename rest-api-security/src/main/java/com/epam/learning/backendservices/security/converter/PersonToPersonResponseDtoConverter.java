package com.epam.learning.backendservices.security.converter;

import com.epam.learning.backendservices.security.dto.PersonResponseDto;
import com.epam.learning.backendservices.security.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonResponseDtoConverter implements Converter<Person, PersonResponseDto> {

    @Override
    public PersonResponseDto convert(Person person) {
        PersonResponseDto personResponseDto = new PersonResponseDto();
        BeanUtils.copyProperties(person, personResponseDto);
        personResponseDto.setBirthday(person.getBirthday().toString());
        return personResponseDto;
    }

}
