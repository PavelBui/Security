package com.epam.learning.backendservices.security.service.impl;

import com.epam.learning.backendservices.security.model.CachedValue;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class LoginAttemptService {

    public static final int MAX_ATTEMPT = 3;
    public static final int BLOCK_DURATION_MIN = 5;
    private LoadingCache<String, CachedValue> attemptsCache;

    public LoginAttemptService() {
        attemptsCache = CacheBuilder.newBuilder()
                .expireAfterWrite(BLOCK_DURATION_MIN, TimeUnit.MINUTES)
                .build(new CacheLoader<>() {
            @Override
            public CachedValue load(final String key) {
                return new CachedValue(0, LocalDateTime.now());
            }
        });
    }

    public void loginFailed(final String key) {
        CachedValue cachedValue = new CachedValue();
        try {
            cachedValue = attemptsCache.get(key);
            cachedValue.setAttempts(cachedValue.getAttempts() + 1);
        } catch (final ExecutionException e) {
            cachedValue.setAttempts(0);
        }
        if (isBlocked(key) && cachedValue.getBlockedTimestamp() == null) {
            cachedValue.setBlockedTimestamp(LocalDateTime.now());
        }
        attemptsCache.put(key, cachedValue);
    }

    public boolean isBlocked(final String key) {
        try {
            return attemptsCache.get(key).getAttempts() >= MAX_ATTEMPT;
        } catch (final ExecutionException e) {
            return false;
        }
    }

    public CachedValue getCachedValue(final String key) {
        return attemptsCache.getUnchecked(key);
    }

}
