package com.epam.learning.backendservices.security.exeption;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id) {
        super("Person with id: " + id + " not found");
    }
}
