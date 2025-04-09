package com.iggyzxc.anyareappbackend.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data // Lombok: Generates getters, setters, toString, equals, hashCode
@Builder // Lombok: Provides builder pattern
@NoArgsConstructor
@AllArgsConstructor
@Entity // JPA: Marks this class as a JPA entity (a table in the DB)
@Table(name = "users") // JPA: Specifies the table name
public class User {

    @Id // JPA: Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA: Configures auto-increment for the ID
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false) // JPA: Column constraints
    private String email;

    @Column(nullable = false)
    private String passwordHash; // Store hashed passwords, not plain text!

    private String phoneNumber;

    @Lob // JPA: Suggests mapping to a large object type (TEXT in MySQL)
    @Column(columnDefinition = "TEXT")
    private String addressDetails;

    @Enumerated(EnumType.STRING) // JPA: Stores the enum value as a String (e.g., "RESIDENT")
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus; // Nullable initially or for non-residents

    // Foreign key for who approved - Just store the ID for now
    // We can add the @ManyToOne relationship later if needed
    private Long approvedByUserId;

    private LocalDateTime approvedAt;

    private String profilePictureUrl;

    @Builder.Default // Lombok: Set default value for builder
    private boolean isActive = true;

    @CreationTimestamp // Hibernate: Automatically sets field value on creation
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp // Hibernate: Automatically sets field value on update
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}