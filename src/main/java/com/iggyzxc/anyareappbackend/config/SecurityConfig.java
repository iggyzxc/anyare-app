package com.iggyzxc.anyareappbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Marks this class as a source of bean definitions
public class SecurityConfig {

    @Bean // Exposes the returned object as a Spring bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for strong, salted password hashing
        return new BCryptPasswordEncoder();
    }

    @Bean // Defines the security filter chain -> configures HTTP security
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection - common for stateless REST APIs
                // You might enable and configure it properly if using sessions or non-browser clients need protection
                .csrf(AbstractHttpConfigurer::disable)

                // Configure authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Allow access to all endpoints under /api/v1/auth/** (like register, login later) without authentication
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        // Any other request must be authenticated
                        .anyRequest().authenticated()
                )

                // Configure session management to be stateless - common for APIs using tokens (like JWT)
                // Spring Security won't create or use HTTP sessions
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        // We will add JWT filter configuration here later

        return http.build(); // Build the security filter chain
    }

    // We will add more security configurations here later (like HTTP security rules)
}
