package org.example.interviewmanagement.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.interviewmanagement.dto.CandidateDto;
import org.example.interviewmanagement.dto.request.CandidateRequestDto;
import org.example.interviewmanagement.entities.Candidate;
import org.example.interviewmanagement.service.UserService;

public class CandidateMapper {
    private static final UserService service = new UserService();
//    public static CandidateDto mapToCandidateDto(Candidate candidate) {
//        return new CandidateDto(
//                candidate.getCandidateId(),
//                candidate.getFullName(),
//                candidate.getEmail(),
//                candidate.getPhoneNumber(),
//                candidate.getCurrentPosition(),
//                candidate.getRecruiterOwner().getFullName(),
//                candidate.getStatus()
//        );
//    }

    public static Candidate mapToCandidate(CandidateRequestDto requestDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return new Candidate(
                    requestDto.getCandidateId(),
                    requestDto.getFullName(),
                    requestDto.getEmail(),
                    requestDto.getGender(),
                    requestDto.getDob(),
                    requestDto.getAddress(),
                    requestDto.getPhoneNumber(),
                    requestDto.getCvFilePath(),
                    requestDto.getCurrentPosition(),
                    objectMapper.writeValueAsString(requestDto.getSkills()),
                    requestDto.getYearsOfExperience(),
                    requestDto.getHighestEducation(),
                    requestDto.getStatus(),
                    requestDto.getNote(),
                    service.findByUserId(requestDto.getUserId())
            );
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}