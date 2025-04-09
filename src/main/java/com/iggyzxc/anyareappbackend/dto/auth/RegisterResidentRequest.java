package com.iggyzxc.anyareappbackend.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Add validation annotations later (e.g., @NotBlank, @Email, @Size)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResidentRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password; // Plain text password from user input
    private String phoneNumber; // Optional?
    private String addressDetails; // Optional? Or required for verification? Let's make optional for now.

    // We don't include role or verificationStatus here - the backend will set those defaults.
}
