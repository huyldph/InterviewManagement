package org.example.interviewmanagement.dto.request;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRequestDto {
    private Integer candidateId;

    private String fullName;

    private String email;

    private String gender;

    private LocalDate dob;

    private String address;

    private String phoneNumber;

    private String cvFilePath;

    private String currentPosition;

    private List<String> skills;

    private Integer yearsOfExperience;

    private String highestEducation;

    private String status = "Open";

    private String note;

    private Integer userId;
}
