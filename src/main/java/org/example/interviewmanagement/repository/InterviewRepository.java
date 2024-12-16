package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.InterviewDto;
import org.example.interviewmanagement.entities.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
                i.scheduleEnd,
                i.notes,
                i.meetingLink,
                i.location,
                i.result,
                i.status,
                j.title,
                c.candidateId,
                u.userId,
                j.jobId
            ) from Interview i join i.candidate c join i.job j join i.interviewer u
            """)
    Page<InterviewDto> getAllInterviews(Pageable pageable);

    @Query("""
            select new org.example.interviewmanagement.dto.InterviewDto(
                i.interviewId,
                i.title,
                c.fullName,
                i.interviewer.fullName,
                i.scheduleStart,
                i.scheduleEnd,
                i.notes,
                i.meetingLink,
                i.location,
                i.result,
                i.status,
                j.title,
                c.candidateId,
                u.userId,
                j.jobId
            ) from Interview i join i.candidate c join i.job j join i.interviewer u
            where i.interviewId = :interviewId
            """)
    InterviewDto findByInterviewId(@Param("interviewId") Integer interviewId);
}
