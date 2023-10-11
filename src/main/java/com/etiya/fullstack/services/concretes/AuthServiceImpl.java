package com.etiya.fullstack.services.concretes;

/**
 * @author musa.balin
 */

import com.etiya.fullstack.core.jwt.JwtService;
import com.etiya.fullstack.entities.User;
import com.etiya.fullstack.entities.requests.auth.LoginRequest;
import com.etiya.fullstack.entities.requests.auth.RegisterRequest;
import com.etiya.fullstack.entities.resposes.auth.AuthenticationResponse;
import com.etiya.fullstack.repositories.UserRepository;
import com.etiya.fullstack.services.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .lastName(request.getLastName())
                .userName(request.getUsername())
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByUserName(request.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

}