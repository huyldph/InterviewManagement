package org.example.interviewmanagement.controller;

import org.example.interviewmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);

        try {
            return ResponseEntity.ok(jobService.getAllJobs(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching jobs: " + e.getMessage());
        }
    }
}
