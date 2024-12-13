package org.example.interviewmanagement.repository;

import org.example.interviewmanagement.dto.UserDto;
import org.example.interviewmanagement.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("""
            select new org.example.interviewmanagement.dto.UserDto(
                u.userId,
                u.fullName,
                u.email,
                u.phone,
                u.role,
                u.isActive
            ) from User u
            """)
    Page<UserDto> getAllUsers(Pageable pageable);
}
