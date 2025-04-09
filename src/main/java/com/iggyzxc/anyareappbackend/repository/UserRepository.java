package com.iggyzxc.anyareappbackend.repository;

import com.iggyzxc.anyareappbackend.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Marks this as a Spring Data repository (component scanning)
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository gives us basic CRUD methods: save(), findById(), findAll(), deleteById(), etc.

    // custom query methods
    Optional<User> findByEmail(String email); // Find user by email (useful for login)
}
