package com.starter.springboot.service;

import com.starter.springboot.dto.AuthRequest;
import com.starter.springboot.dto.AuthResponse;
import com.starter.springboot.entity.Role;
import com.starter.springboot.entity.User;
import com.starter.springboot.repository.RoleRepository;
import com.starter.springboot.repository.UserRepository;
import com.starter.springboot.security.MyUserDetailsService;
import com.starter.springboot.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;



    private final MyUserDetailsService myUserDetailsService;

    public String register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found in database!"));
        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);
        return "User registered successfully!";
    }
    @Transactional(readOnly = true)
    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getIdentifiers(),
                        authRequest.getPassword()
                )
        );

        UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authRequest.getIdentifiers());

        String token = jwtUtil.generateToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .username(userDetails.getUsername())
                .roles(userDetails.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList())
                .build();
    }
}
