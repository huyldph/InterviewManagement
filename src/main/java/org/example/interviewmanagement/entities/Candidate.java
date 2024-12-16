package org.example.interviewmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateId;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    private LocalDate dob;

    private String address;

    private String phoneNumber;

    private String cvFilePath;

    private String currentPosition;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;

    private Integer yearsOfExperience;

    private String highestEducation;

    private String status = "Open";

    private String note;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "recruiterOwner")
    private User recruiterOwner;

}

