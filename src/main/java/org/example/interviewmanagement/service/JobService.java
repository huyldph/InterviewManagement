package org.example.interviewmanagement.service;

import org.example.interviewmanagement.dto.JobDto;
import org.example.interviewmanagement.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Page<JobDto> getAllJobs(Pageable pageable) {
        return jobRepository.getAllJobs(pageable);
    }
}
