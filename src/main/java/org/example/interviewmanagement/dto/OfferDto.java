package org.example.interviewmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
    private Integer offerId;

    private String status = "Waiting for approval";

    private String notes;

    private String candidateName;

    private String candidateEmail;

    private String approvedBy;

    private String department;
}
