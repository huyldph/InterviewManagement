package org.example.interviewmanagement.service;

import org.example.interviewmanagement.dto.InterviewDto;
import org.example.interviewmanagement.entities.Interview;
import org.example.interviewmanagement.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    public Page<InterviewDto> getAllInterviews(Pageable pageable) {
        return interviewRepository.getAllInterviews(pageable);
    }

    public InterviewDto findByInterviewId(Integer interviewId) {
        return interviewRepository.findByInterviewId(interviewId);
    }

    public Interview findById(Integer interviewId) {
        return interviewRepository.findById(interviewId).orElse(null);
    }

    public void saveInterview(Interview entity) {
        interviewRepository.save(entity);
    }

    public void deleteInterview(Integer interviewId) {
        interviewRepository.deleteById(interviewId);
    }

    public void updateInterview(Interview entity) {
        interviewRepository.save(entity);
    }
}
