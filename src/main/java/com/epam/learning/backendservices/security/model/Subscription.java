package com.epam.learning.backendservices.security.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name="subscriptionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personId", nullable = false)
    private Person person;

    @Column(name="subscriptionStartDate")
    private LocalDate startDate;

    public Subscription() {}

    public Subscription(Long id, Person person, LocalDate startDate) {
        this.id = id;
        this.person = person;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", person=" + person +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id.equals(that.id) && person.equals(that.person) && startDate.equals(that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, startDate);
    }
}
