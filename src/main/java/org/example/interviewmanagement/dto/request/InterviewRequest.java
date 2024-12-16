package org.example.interviewmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterviewRequest {
    private String title;

    private Integer candidateId;

    private Integer userId;

    private Integer jobId;

    private LocalDateTime scheduleStart;

    private LocalDateTime scheduleEnd;

    private String notes;

    private String meetingLink;

    private String location;
}
