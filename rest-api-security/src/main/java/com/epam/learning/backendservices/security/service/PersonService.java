package com.epam.learning.backendservices.security.service;

import com.epam.learning.backendservices.security.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Long id);

    Optional<Person> getPerson(Long id);

    List<Person> getAllPerson();

}
