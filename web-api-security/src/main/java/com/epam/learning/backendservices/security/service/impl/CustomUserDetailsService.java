package com.epam.learning.backendservices.security.service.impl;

import com.epam.learning.backendservices.security.model.UserAuthority;
import com.epam.learning.backendservices.security.model.User;
import com.epam.learning.backendservices.security.repository.UserAuthorityRepository;
import com.epam.learning.backendservices.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private UserAuthorityRepository userAuthorityRepository;
    private LoginAttemptService loginAttemptService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        } else {
            if (loginAttemptService.isBlocked(username)) {
                throw new LockedException("User is blocked");
            }
        }
        User user = optionalUser.get();
        String userName = user.getUsername();
        List<String> rolesList = userAuthorityRepository.findAllByUsername(userName).stream()
                .map(UserAuthority::getAuthority)
                .collect(Collectors.toList());
        String[] roles = rolesList.toArray(new String[]{});
        return org.springframework.security.core.userdetails.User.withUsername(userName)
                .password(user.getPassword())
                .authorities(roles).build();
    }
}
