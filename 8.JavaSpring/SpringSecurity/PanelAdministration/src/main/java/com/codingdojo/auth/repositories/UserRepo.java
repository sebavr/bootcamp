package com.codingdojo.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.auth.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}