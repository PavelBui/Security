package com.epam.learning.backendservices.security.repository;

import com.epam.learning.backendservices.security.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
