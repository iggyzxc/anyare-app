package com.iggyzxc.anyareappbackend.dto.auth;

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

    private String firstName;
    private String lastName;
    private String email;
    private String password; // Plain text password from user input
    private String phoneNumber; // Optional?
    private String addressDetails; // Optional? Or required for verification? Let's make optional for now.

    // We don't include role or verificationStatus here - the backend will set those defaults.
}
