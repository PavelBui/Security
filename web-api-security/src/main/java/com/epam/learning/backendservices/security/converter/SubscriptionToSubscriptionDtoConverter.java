package com.epam.learning.backendservices.security.converter;

import com.epam.learning.backendservices.security.dto.SubscriptionDto;
import com.epam.learning.backendservices.security.model.Subscription;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionToSubscriptionDtoConverter implements Converter<Subscription, SubscriptionDto> {

    @Override
    public SubscriptionDto convert(Subscription subscription) {
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        BeanUtils.copyProperties(subscription, subscriptionDto);
        subscriptionDto.setPersonId(subscription.getPerson().getId());
        subscriptionDto.setStartDate(subscription.getStartDate().toString());
        return subscriptionDto;
    }

}
