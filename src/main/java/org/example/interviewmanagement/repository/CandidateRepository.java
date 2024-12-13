package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.CandidateDto;
import org.example.interviewmanagement.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query("""
            select new org.example.interviewmanagement.dto.CandidateDto(
                c.candidateId,
                c.fullName,
                c.email,
                c.gender,
                c.dob,
                c.address,
                c.phoneNumber,
                c.cvFilePath,
                c.currentPosition,
                c.skills,
                c.yearsOfExperience,
                c.highestEducation,
                c.status,
                c.note,
                u.fullName
            ) from Candidate c join c.recruiterOwner u
            """)
    Page<CandidateDto> getAllCandidates(Pageable pageable);

    @Query("""
            select new org.example.interviewmanagement.dto.CandidateDto(
                c.candidateId,
                c.fullName,
                c.email,
                c.gender,
                c.dob,
                c.address,
                c.phoneNumber,
                c.cvFilePath,
                c.currentPosition,
                c.skills,
                c.yearsOfExperience,
                c.highestEducation,
                c.status,
                c.note,
                u.fullName
            ) from Candidate c join c.recruiterOwner u
            where c.candidateId = :candidateId
            """)
    CandidateDto findByCandidateId(@Param("candidateId") Integer candidateId);
}
