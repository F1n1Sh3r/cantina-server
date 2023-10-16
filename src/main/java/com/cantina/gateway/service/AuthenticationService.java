package com.cantina.gateway.service;

import com.cantina.gateway.model.User;


public interface AuthenticationService
{
    User signInAndReturnJWT(User signInRequest);
}
