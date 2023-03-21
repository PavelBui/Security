package com.epam.learning.backendservices.security.dto;

public class SubscriptionRequestDto {

    private Long id;

    private Long personId;

    public SubscriptionRequestDto() {}

    public SubscriptionRequestDto(Long id, Long personId) {
        this.id = id;
        this.personId = personId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
