package com.epam.learning.backendservices.security.dto;

public class SubscriptionDto {

    private Long id;

    private Long personId;

    private String startDate;

    public SubscriptionDto() {}

    public SubscriptionDto(Long id, Long personId, String startDate) {
        this.id = id;
        this.personId = personId;
        this.startDate = startDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
