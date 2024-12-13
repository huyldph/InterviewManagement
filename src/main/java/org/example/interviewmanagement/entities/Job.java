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
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    private String title;

    private String requiredSkills;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double salaryRangeFrom;

    private Double salaryRangeTo;

    private String workingAddress;

    private String benefits;

    private String level;

    private String description;

    private String status = "Draft";

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private User createdBy;
}

