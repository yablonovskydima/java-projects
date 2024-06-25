package com.lesson.lesson16.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class Task
{
    @NotBlank()
    @Size(max = 100)
    @JsonFormat
    private String name;
    @Size(max = 500)
    @NotBlank()
    @JsonFormat
    private String description;
    @NotNull()
    @Future()
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "UTC")
    private Date deadline;


}
