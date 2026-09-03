package com.smolurl.auth_service.controller;

import com.smolurl.auth_service.dto.AuthResponse;
import com.smolurl.auth_service.dto.LoginRequest;
import com.smolurl.auth_service.dto.RegisterRequest;
import com.smolurl.auth_service.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/api/me")
public ResponseEntity<String> me() {
    return ResponseEntity.ok("You are authenticated!");
}
}