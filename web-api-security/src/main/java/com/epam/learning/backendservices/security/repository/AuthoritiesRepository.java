package com.epam.learning.backendservices.security.repository;

import com.epam.learning.backendservices.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority, String> {

    List<Authority> findByUsername(String username);

}
