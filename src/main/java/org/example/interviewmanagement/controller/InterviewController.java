package org.example.interviewmanagement.controller;

import org.example.interviewmanagement.dto.request.InterviewRequest;
import org.example.interviewmanagement.entities.Candidate;
import org.example.interviewmanagement.entities.Interview;
import org.example.interviewmanagement.entities.Job;
import org.example.interviewmanagement.entities.User;
import org.example.interviewmanagement.service.CandidateService;
import org.example.interviewmanagement.service.InterviewService;
import org.example.interviewmanagement.service.JobService;
import org.example.interviewmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/interviews")
    public ResponseEntity<?> getInterviews(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);

        try {
            return ResponseEntity.ok(interviewService.getAllInterviews(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching interviews: " + e.getMessage());
        }
    }

    @GetMapping("/interviews/{id}")
    public ResponseEntity<?> getInterviewById(@PathVariable("id") Integer interviewId) {
        try {
            return ResponseEntity.ok(interviewService.findByInterviewId(interviewId));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching interview: " + e.getMessage());
        }
    }

    @DeleteMapping("/interviews/{id}")
    public ResponseEntity<?> deleteInterview(@PathVariable("id") Integer interviewId) {
        try {
            interviewService.deleteInterview(interviewId);
            return ResponseEntity.ok("Interview deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting interview: " + e.getMessage());
        }
    }

    @PostMapping("/interviews")
    public ResponseEntity<?> saveInterview(@RequestBody InterviewRequest request) {
        try {
            Job job = jobService.findByJobId(request.getJobId());
            User interviewer = userService.findByUserId(request.getUserId());
            Candidate candidate = candidateService.findById(request.getCandidateId());
            candidate.setStatus("Waiting to interview");
            candidateService.updateCandidate(candidate);

            Interview interview = new Interview();
            interview.setTitle(request.getTitle());
            interview.setScheduleStart(request.getScheduleStart());
            interview.setScheduleEnd(request.getScheduleEnd());
            interview.setNotes(request.getNotes());
            interview.setMeetingLink(request.getMeetingLink());
            interview.setLocation(request.getLocation());
            interview.setJob(job);
            interview.setCandidate(candidate);
            interview.setInterviewer(interviewer);
            interviewService.saveInterview(interview);
            return ResponseEntity.ok("Interview saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving interview: " + e.getMessage());
        }
    }

    @PutMapping("/interviews/{interviewId}")
    public ResponseEntity<?> updateInterview(@PathVariable("interviewId") Integer interviewId, @RequestBody InterviewRequest request) {
        try {
            Job job = jobService.findByJobId(request.getJobId());
            User interviewer = userService.findByUserId(request.getUserId());
            Candidate candidate = candidateService.findById(request.getCandidateId());

            Interview interview = new Interview();
            interview.setInterviewId(interviewId);
            interview.setTitle(request.getTitle());
            interview.setScheduleStart(request.getScheduleStart());
            interview.setScheduleEnd(request.getScheduleEnd());
            interview.setNotes(request.getNotes());
            interview.setMeetingLink(request.getMeetingLink());
            interview.setLocation(request.getLocation());
            interview.setJob(job);
            interview.setCandidate(candidate);
            interview.setInterviewer(interviewer);
            interviewService.updateInterview(interview);
            return ResponseEntity.ok("Interview updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating interview: " + e.getMessage());
        }
    }
}
