package com.iggyzxc.anyareappbackend.service;

import com.iggyzxc.anyareappbackend.dto.auth.RegisterResidentRequest;
import com.iggyzxc.anyareappbackend.entity.user.Role;
import com.iggyzxc.anyareappbackend.entity.user.User;
import com.iggyzxc.anyareappbackend.entity.user.VerificationStatus;
import com.iggyzxc.anyareappbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Marks this class as a Spring service component
@RequiredArgsConstructor // Lombok: Generates constructor for final fields -> enables constructor injection
public class AuthServiceImpl implements AuthService {

    // Injected by Spring via constructor
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional // Ensures the method runs within a database transaction
    public void registerResident(RegisterResidentRequest request) {
        // 1. Check if email already exists (using the method we added in UserRepository)
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            // TODO: Create a specific exception for this case later
            throw new IllegalArgumentException("Email already in use");
        }

        // 2. Create a new User entity
        User newUser = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword())) // Hash the password!
                .phoneNumber(request.getPhoneNumber())
                .addressDetails(request.getAddressDetails())
                .role(Role.RESIDENT) // Set default role
                .verificationStatus(VerificationStatus.PENDING)
                .isActive(true) // Use the default from @Builder.Default
                // createdAt/updatedAt are handled by @CreationTimestamp/@UpdateTimestamp
                .build();

        // 3. Save the new user to the database
        userRepository.save(newUser);

        // 4. TODO: Optionally send a notification/email to Barangay users about pending registration
    }
}
