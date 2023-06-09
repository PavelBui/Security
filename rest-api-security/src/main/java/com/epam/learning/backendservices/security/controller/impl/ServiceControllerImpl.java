package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.ServiceController;
import com.epam.learning.backendservices.security.dto.SubscriptionRequestDto;
import com.epam.learning.backendservices.security.dto.SubscriptionResponseDto;
import com.epam.learning.backendservices.security.exeption.PersonNotFoundException;
import com.epam.learning.backendservices.security.exeption.SubscriptionNotFoundException;
import com.epam.learning.backendservices.security.model.Subscription;
import com.epam.learning.backendservices.security.service.PersonService;
import com.epam.learning.backendservices.security.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class ServiceControllerImpl implements ServiceController {

    private SubscriptionService subscriptionService;
    private PersonService personService;
    private Converter<Subscription, SubscriptionResponseDto> subscriptionToSubscriptionResponseDtoConvertor;
    private Converter<SubscriptionRequestDto, Subscription> subscriptionRequestDtoToSubscriptionConvertor;

    public EntityModel<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionRequestDtoToSubscriptionConvertor.convert(subscriptionRequestDto);
        Long personId = subscription.getPerson().getId();
        subscription.setPerson(personService.getPerson(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId)));
        return toModel(subscriptionToSubscriptionResponseDtoConvertor.convert(subscriptionService.createSubscription(subscription)));
    }

    public EntityModel<SubscriptionResponseDto> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionRequestDtoToSubscriptionConvertor.convert(subscriptionRequestDto);
        Long personId = subscription.getPerson().getId();
        subscription.setPerson(personService.getPerson(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId)));
        return toModel(subscriptionToSubscriptionResponseDtoConvertor.convert(subscriptionService.updateSubscription(subscription)));
    }

    public ResponseEntity<String> deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok().build();
    }

    public EntityModel<SubscriptionResponseDto> getSubscription(@PathVariable Long id) {
        return toModel(subscriptionToSubscriptionResponseDtoConvertor.convert(
                subscriptionService.getSubscription(id)
                        .orElseThrow(() -> new SubscriptionNotFoundException((id)))));
    }

    public List<EntityModel<SubscriptionResponseDto>> getAllSubscription() {
        return subscriptionService.getAllSubscription()
                .stream()
                .map(subscription -> subscriptionToSubscriptionResponseDtoConvertor.convert(subscription))
                .map(ServiceControllerImpl::toModel)
                .collect(Collectors.toList());
    }

    private static EntityModel<SubscriptionResponseDto> toModel(SubscriptionResponseDto response) {
        return EntityModel.of(response,
                linkTo(methodOn(ServiceControllerImpl.class).getSubscription(response.getId())).withSelfRel(),
                linkTo(methodOn(ServiceControllerImpl.class).getAllSubscription()).withRel("getAllSubscriptions"),
                linkTo(methodOn(ServiceControllerImpl.class).deleteSubscription(response.getId())).withRel("deleteSubscription"),
                linkTo(methodOn(ServiceControllerImpl.class).createSubscription(new SubscriptionRequestDto())).withRel("createSubscription"),
                linkTo(methodOn(ServiceControllerImpl.class).updateSubscription(new SubscriptionRequestDto())).withRel("updateSubscription")
        );
    }
}
