package com.epam.learning.backendservices.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
public class Person {
    @Id
    @Column(name="personId")
    private Long id;

    @Column(name="personName")
    private String name;

    @Column(name="personSurname")
    private String surname;

    @Column(name="personBirthday")
    private LocalDate birthday;

}
