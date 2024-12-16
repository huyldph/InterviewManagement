package org.example.interviewmanagement.dto.request;

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
public class JobRequest {
    private String title;

    private List<String> requiredSkills;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<String> level;

    private Double salaryRangeFrom;

    private Double salaryRangeTo;

    private String workingAddress;

    private List<String> benefits;

    private String description;
}
