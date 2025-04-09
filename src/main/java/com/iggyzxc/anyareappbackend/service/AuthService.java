package com.iggyzxc.anyareappbackend.service;

import com.iggyzxc.anyareappbackend.dto.auth.RegisterResidentRequest;

public interface AuthService {
    void registerResident(RegisterResidentRequest request);
    // We can add login methods etc. here later
}
