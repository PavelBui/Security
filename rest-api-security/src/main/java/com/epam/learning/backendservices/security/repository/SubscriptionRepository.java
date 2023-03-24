package com.epam.learning.backendservices.security.repository;

import com.epam.learning.backendservices.security.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
