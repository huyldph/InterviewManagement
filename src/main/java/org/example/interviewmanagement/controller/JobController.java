package org.example.interviewmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.interviewmanagement.dto.request.JobRequest;
import org.example.interviewmanagement.entities.Job;
import org.example.interviewmanagement.service.JobService;
import org.example.interviewmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getJobs(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);

        try {
            return ResponseEntity.ok(jobService.getAllJobs(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching jobs: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(jobService.findByJobId(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching job: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Integer id) {
        try {
            Job job = jobService.findByJobId(id);
            jobService.deleteJob(job);
            return ResponseEntity.ok("Job deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting job: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> saveJob(@RequestBody JobRequest request) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String skillsJson = objectMapper.writeValueAsString(request.getRequiredSkills());
            String levelJson = objectMapper.writeValueAsString(request.getLevel());
            String benefitsJson = objectMapper.writeValueAsString(request.getBenefits());

            Job job = new Job();
            job.setTitle(request.getTitle());
            job.setRequiredSkills(skillsJson);
            job.setStartDate(request.getStartDate());
            job.setEndDate(request.getEndDate());
            job.setSalaryRangeFrom(request.getSalaryRangeFrom());
            job.setSalaryRangeTo(request.getSalaryRangeTo());
            job.setWorkingAddress(request.getWorkingAddress());
            job.setBenefits(benefitsJson);
            job.setLevel(levelJson);
            job.setDescription(request.getDescription());
            jobService.saveJob(job);
            return ResponseEntity.ok("Job saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving job: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Integer id, @RequestBody JobRequest request) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String skillsJson = objectMapper.writeValueAsString(request.getRequiredSkills());
            String levelJson = objectMapper.writeValueAsString(request.getLevel());
            String benefitsJson = objectMapper.writeValueAsString(request.getBenefits());

            Job job = new Job();
            job.setJobId(id);
            job.setTitle(request.getTitle());
            job.setRequiredSkills(skillsJson);
            job.setStartDate(request.getStartDate());
            job.setEndDate(request.getEndDate());
            job.setSalaryRangeFrom(request.getSalaryRangeFrom());
            job.setSalaryRangeTo(request.getSalaryRangeTo());
            job.setWorkingAddress(request.getWorkingAddress());
            job.setBenefits(benefitsJson);
            job.setLevel(levelJson);
            job.setDescription(request.getDescription());
            jobService.updateJob(job);
            return ResponseEntity.ok("Job updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating job: " + e.getMessage());
        }
    }
}
