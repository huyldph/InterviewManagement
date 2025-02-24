package org.example.interviewmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer userId;

    private String userName;

    private String email;

    private String phone;

    private String role;

    private Boolean status = true;
}
