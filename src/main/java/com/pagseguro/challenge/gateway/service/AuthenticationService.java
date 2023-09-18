package com.pagseguro.challenge.gateway.service;

import com.pagseguro.challenge.gateway.model.User;


public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
