package com.epam.learning.backendservices.security.repository;

import com.epam.learning.backendservices.security.model.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

    List<UserAuthority> findAllByUsername(String username);

}
