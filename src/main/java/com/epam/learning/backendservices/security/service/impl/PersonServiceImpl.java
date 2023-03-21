package com.epam.learning.backendservices.security.service.impl;

import com.epam.learning.backendservices.security.exeption.PersonNotFoundException;
import com.epam.learning.backendservices.security.model.Subscription;
import com.epam.learning.backendservices.security.repository.SubscriptionRepository;
import com.epam.learning.backendservices.security.service.PersonService;
import com.epam.learning.backendservices.security.repository.PersonRepository;
import com.epam.learning.backendservices.security.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Person createPerson(Person person) {
        Long id = person.getId();
        return personRepository.findById(id)
                .orElseGet(() -> {
                    person.setId(null);
                    return personRepository.save(person);
                });
    }

    @Override
    public Person updatePerson(Person person) {
        Long id = person.getId() != null ? person.getId() : 0L;
        return personRepository.findById(id)
                .map(currentPerson -> {
                    currentPerson.setName(person.getName());
                    currentPerson.setSurname(person.getSurname());
                    currentPerson.setBirthday(person.getBirthday());
                    return personRepository.save(currentPerson);
                })
                .orElseGet(() -> personRepository.save(person));
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        List<Subscription> subscriptions = (List<Subscription>) subscriptionRepository.findAll();
        subscriptions.forEach(subscription -> {
                    if (Objects.equals(subscription.getPerson().getId(), id)) {
                        subscriptionRepository.deleteById(subscription.getId());
                    }
                });
        personRepository.deleteById(person.getId());
    }

    @Override
    public Optional<Person> getPerson(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }
}
