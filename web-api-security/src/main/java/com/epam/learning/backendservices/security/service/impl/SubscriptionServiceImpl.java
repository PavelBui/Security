package com.epam.learning.backendservices.security.service.impl;

import com.epam.learning.backendservices.security.exeption.SubscriptionNotFoundException;
import com.epam.learning.backendservices.security.model.Subscription;
import com.epam.learning.backendservices.security.repository.SubscriptionRepository;
import com.epam.learning.backendservices.security.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        Long id = subscription.getId();
        return subscriptionRepository.findById(id)
                .orElseGet(() -> {
                    subscription.setId(null);
                    subscription.setStartDate(LocalDate.now());
                    return subscriptionRepository.save(subscription);
                });
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        Long id = subscription.getId() != null ? subscription.getId() : 0L;
        return subscriptionRepository.findById(id)
                .map(currentSubscription -> {
                    currentSubscription.setPerson(subscription.getPerson());
                    currentSubscription.setStartDate(LocalDate.now());
                    return subscriptionRepository.save(currentSubscription);
                })
                .orElseGet(() -> subscriptionRepository.save(subscription));
    }

    @Override
    public void deleteSubscription(Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException(id));
        subscriptionRepository.deleteById(subscription.getId());
    }

    @Override
    public Optional<Subscription> getSubscription(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }
}
