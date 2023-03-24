package com.epam.learning.backendservices.security.controller.impl;

import com.epam.learning.backendservices.security.controller.BlockedController;
import com.epam.learning.backendservices.security.model.User;
import com.epam.learning.backendservices.security.repository.UserRepository;
import com.epam.learning.backendservices.security.service.impl.LoginAttemptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class BlockedControllerImpl implements BlockedController {

    private UserRepository userRepository;
    private LoginAttemptService loginAttemptService;

    @Override
    public String blockedPage(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        Map<String, LocalDateTime> blockedUsers = users.stream()
                .map(User::getUsername)
                .filter(userName -> loginAttemptService.isBlocked(userName))
                .collect(Collectors.toMap(user -> user, user -> loginAttemptService.getCachedValue(user).getBlockedTimestamp()));
        if (!blockedUsers.isEmpty()) {
            model.addAttribute("blockedUsers", blockedUsers);
        }
        return "blocked";
    }
}
