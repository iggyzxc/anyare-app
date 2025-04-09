package com.iggyzxc.anyareappbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // Marks this class as a source of bean definitions
public class SecurityConfig {

    @Bean // Exposes the returned object as a Spring bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for strong, salted password hashing
        return new BCryptPasswordEncoder();
    }

    // We will add more security configurations here later (like HTTP security rules)
}
