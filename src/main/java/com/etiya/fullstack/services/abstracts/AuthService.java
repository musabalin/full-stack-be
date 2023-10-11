package com.etiya.fullstack.services.abstracts;

import com.etiya.fullstack.entities.requests.auth.LoginRequest;
import com.etiya.fullstack.entities.requests.auth.RegisterRequest;
import com.etiya.fullstack.entities.resposes.auth.AuthenticationResponse;

/**
 * @author musa.balin
 */
public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
