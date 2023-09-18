package com.pagseguro.challenge.gateway.service;

import com.pagseguro.challenge.gateway.model.Role;
import com.pagseguro.challenge.gateway.model.User;

import java.util.Optional;


public interface UserService
{
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
