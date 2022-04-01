package com.raccoon.learnapp.student.impl.model;

import lombok.Data;

@Data
public class StudentRegistrationData {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
}
