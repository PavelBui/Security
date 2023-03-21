package com.epam.learning.backendservices.security.converter;

import com.epam.learning.backendservices.security.dto.SubscriptionResponseDto;
import com.epam.learning.backendservices.security.model.Subscription;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionToSubscriptionResponseDtoConverter implements Converter<Subscription, SubscriptionResponseDto> {

    @Override
    public SubscriptionResponseDto convert(Subscription subscription) {
        SubscriptionResponseDto subscriptionResponseDto = new SubscriptionResponseDto();
        BeanUtils.copyProperties(subscription, subscriptionResponseDto);
        subscriptionResponseDto.setPersonId(subscription.getPerson().getId());
        subscriptionResponseDto.setStartDate(subscription.getStartDate().toString());
        return subscriptionResponseDto;
    }

}
