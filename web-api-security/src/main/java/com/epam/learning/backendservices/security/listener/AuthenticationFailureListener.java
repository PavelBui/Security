package com.epam.learning.backendservices.security.listener;

import com.epam.learning.backendservices.security.repository.UserRepository;
import com.epam.learning.backendservices.security.service.impl.LoginAttemptService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private LoginAttemptService loginAttemptService;

    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        Object principal = e.getAuthentication().getPrincipal();
        if (principal instanceof String) {
            String username = (String) e.getAuthentication().getPrincipal();
            if (userRepository.findById(username).isPresent()) {
                loginAttemptService.loginFailed(username);
            }
        }
    }
}
