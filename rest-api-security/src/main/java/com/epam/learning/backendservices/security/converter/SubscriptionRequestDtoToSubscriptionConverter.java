package com.epam.learning.backendservices.security.converter;

import com.epam.learning.backendservices.security.dto.SubscriptionRequestDto;
import com.epam.learning.backendservices.security.model.Person;
import com.epam.learning.backendservices.security.model.Subscription;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionRequestDtoToSubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {

    @Override
    public Subscription convert(SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = new Subscription();
        BeanUtils.copyProperties(subscriptionRequestDto, subscription);
        subscription.setPerson(new Person(subscriptionRequestDto.getPersonId()));
        return subscription;
    }

}
