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
public class JobDto {
    private Integer jobId;

    private String title;

    private String requiredSkills;

    private LocalDate startDate;

    private LocalDate endDate;

    private String level;

    private String status = "Draft";
}
