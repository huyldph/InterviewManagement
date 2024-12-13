package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.JobDto;
import org.example.interviewmanagement.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query("""
            select new org.example.interviewmanagement.dto.JobDto(
                j.jobId,
                j.title,
                j.requiredSkills,
                j.startDate,
                j.endDate,
                j.level,
                j.status
            ) from Job j
            """)
    Page<JobDto> getAllJobs(Pageable pageable);
}
