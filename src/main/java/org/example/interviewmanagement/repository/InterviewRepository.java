package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.InterviewDto;
import org.example.interviewmanagement.entities.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    @Query("""
            select new org.example.interviewmanagement.dto.InterviewDto(
                i.interviewId,
                i.title,
                c.fullName,
                i.interviewer.fullName,
                i.scheduleStart,
                i.result,
                i.status,
                j.title
            ) from Interview i join i.candidate c join i.job j
            """)
    Page<InterviewDto> getAllInterviews(Pageable pageable);
}
