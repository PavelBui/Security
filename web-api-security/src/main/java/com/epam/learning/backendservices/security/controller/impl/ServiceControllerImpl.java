package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.ServiceController;
import com.epam.learning.backendservices.security.dto.SubscriptionDto;
import com.epam.learning.backendservices.security.model.Subscription;
import com.epam.learning.backendservices.security.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ServiceControllerImpl implements ServiceController {

    private SubscriptionService subscriptionService;
    private Converter<Subscription, SubscriptionDto> subscriptionToSubscriptionDtoConvertor;

    public String getAllSubscription(Model model) {
        List<SubscriptionDto> subscriptionDtoList = subscriptionService.getAllSubscription()
                .stream()
                .map(subscription -> subscriptionToSubscriptionDtoConvertor.convert(subscription))
                .collect(Collectors.toList());
        model.addAttribute("subscriptions", subscriptionDtoList);
        return "subscription";
    }

}
