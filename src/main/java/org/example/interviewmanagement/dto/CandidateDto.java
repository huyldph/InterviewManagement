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
public class CandidateDto {
    private Integer candidateId;

    private String fullName;

    private String email;

    private String gender;

    private LocalDate dob;

    private String address;

    private String phoneNumber;

    private String cvFilePath;

    private String currentPosition;

    private String skills;

    private Integer yearsOfExperience;

    private String highestEducation;

    private String status;

    private String note;

    private String userName;
}
