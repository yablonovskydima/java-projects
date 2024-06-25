package com.lesson.lesson16.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User
{
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[a-zA-Z]+$")
    @JsonFormat
    private String fullName;

    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$")
    @JsonFormat
    private String email;

    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")
    @JsonFormat
    private String password;

    public String getFullName() {
        return fullName;
    }
}
