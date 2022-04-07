package com.raccoon.learnapp.student.api;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private Integer level;
}
