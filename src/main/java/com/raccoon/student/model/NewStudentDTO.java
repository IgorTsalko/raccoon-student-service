package com.raccoon.student.model;

import lombok.Data;

@Data
public class NewStudentDTO {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
}
