package org.example.interviewmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterviewDto {
    private Integer interviewId;

    private String title;

    private String candidateName;

    private String interviewer;

    private LocalDateTime scheduleStart;

    private String result;

    private String status = "Scheduled";

    private String jobTitle;
}
