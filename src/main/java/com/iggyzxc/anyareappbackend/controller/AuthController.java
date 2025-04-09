package com.iggyzxc.anyareappbackend.controller;

import com.iggyzxc.anyareappbackend.dto.auth.RegisterResidentRequest;
import com.iggyzxc.anyareappbackend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register/resident")
    public ResponseEntity<String> registerResident(@RequestBody RegisterResidentRequest request) {
        authService.registerResident(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful.");
    }
}
