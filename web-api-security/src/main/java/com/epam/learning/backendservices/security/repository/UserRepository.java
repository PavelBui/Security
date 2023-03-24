package com.epam.learning.backendservices.security.repository;

import com.epam.learning.backendservices.security.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
