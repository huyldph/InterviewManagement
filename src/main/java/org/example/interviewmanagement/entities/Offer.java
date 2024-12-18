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
@Table(name = "Offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offerId;

    private String status = "Waiting for approval";

    private String notes;

    private String department;

    private String position;

    private String contractType;

    private String level;

    private LocalDate contractPeriodStart;

    private LocalDate contractPeriodEnd;

    private LocalDate dueDate;

    private Double baseSalary;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "candidateId")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "interviewId")
    private Interview interview;
}