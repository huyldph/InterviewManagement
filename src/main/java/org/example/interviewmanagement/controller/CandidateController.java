package org.example.interviewmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.interviewmanagement.dto.CandidateDto;
import org.example.interviewmanagement.dto.request.CandidateRequestDto;
import org.example.interviewmanagement.entities.Candidate;
import org.example.interviewmanagement.service.CandidateService;
import org.example.interviewmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private UserService userService;

    @GetMapping("/candidates")
    public ResponseEntity<?> getCandidates(@RequestParam(name = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        try {
            Page<CandidateDto> candidates = candidateService.getAllCandidates(pageable);
            return ResponseEntity.ok(candidates);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching candidates: " + e.getMessage());
        }
    }

    @PostMapping("/candidates")
    public ResponseEntity<?> saveCandidate(@RequestBody CandidateRequestDto request) {
        try {
            Candidate candidate = new Candidate();
            candidate.setFullName(request.getFullName());
            candidate.setEmail(request.getEmail());
            candidate.setGender(request.getGender());
            candidate.setDob(request.getDob());
            candidate.setAddress(request.getAddress());
            candidate.setPhoneNumber(request.getPhoneNumber());
            candidate.setCvFilePath(request.getCvFilePath());
            candidate.setCurrentPosition(request.getCurrentPosition());

            ObjectMapper objectMapper = new ObjectMapper();
            String skillsJson = objectMapper.writeValueAsString(request.getSkills());
            candidate.setSkills(skillsJson);
            candidate.setYearsOfExperience(request.getYearsOfExperience());
            candidate.setHighestEducation(request.getHighestEducation());
            candidate.setStatus(request.getStatus());
            candidate.setNote(request.getNote());
            candidate.setRecruiterOwner(userService.findByUserId(request.getUserId()));
            candidateService.saveCandidate(candidate);
            return ResponseEntity.ok("Candidate saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving candidate: " + e.getMessage());
        }
    }

    @GetMapping("/candidates/{id}")
    public ResponseEntity<?> getCandidateById(@PathVariable Integer id) {
        try {
            CandidateDto candidate = candidateService.findByCandidateId(id);
            return ResponseEntity.ok(candidate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching candidate: " + e.getMessage());
        }
    }
}
