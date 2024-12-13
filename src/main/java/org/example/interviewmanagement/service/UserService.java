package org.example.interviewmanagement.service;

import org.example.interviewmanagement.dto.UserDto;
import org.example.interviewmanagement.entities.User;
import org.example.interviewmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.getAllUsers(pageable);
    }

    public User findByUserId(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
