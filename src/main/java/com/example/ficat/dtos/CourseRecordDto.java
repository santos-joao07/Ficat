package com.example.ficat.dtos;

import jakarta.validation.constraints.NotBlank;

public record CourseRecordDto(@NotBlank String name, @NotBlank String type) {
}
