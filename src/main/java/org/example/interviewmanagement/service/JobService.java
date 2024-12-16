package org.example.interviewmanagement.service;

import org.example.interviewmanagement.dto.JobDto;
import org.example.interviewmanagement.entities.Job;
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

    public void saveJob(Job entity) {
        jobRepository.save(entity);
    }

    public Job findByJobId(Integer jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }

    public void deleteJob(Job job) {
        jobRepository.delete(job);
    }

    public void updateJob(Job entity) {
        jobRepository.save(entity);
    }
}
