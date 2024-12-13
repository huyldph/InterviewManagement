package org.example.interviewmanagement.service;

import org.example.interviewmanagement.dto.CandidateDto;
import org.example.interviewmanagement.entities.Candidate;
import org.example.interviewmanagement.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Page<CandidateDto> getAllCandidates(Pageable pageable) {
        return candidateRepository.getAllCandidates(pageable);
    }

    public void saveCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public CandidateDto findByCandidateId(Integer candidateId) {
        return candidateRepository.findByCandidateId(candidateId);
    }
}
