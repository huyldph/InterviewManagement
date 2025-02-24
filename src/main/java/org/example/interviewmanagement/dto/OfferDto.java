package org.example.interviewmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Integer offerId;

    private String status = "Waiting for approval";

    private String notes;

    private String department;

    private Integer candidateId;

    private String position;

    private Integer userId;

    private Integer interviewId;

    private String contractType;

    private String level;

    private LocalDate contractPeriodStart;

    private LocalDate contractPeriodEnd;

    private LocalDate dueDate;

    private Double baseSalary;

    private String candidateName;

    private String candidateEmail;

    private String approvedBy;
}
