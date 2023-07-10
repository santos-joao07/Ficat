package com.example.ficat.dtos;

import jakarta.validation.constraints.NotBlank;

public record FacultyRecordDto(@NotBlank String name) {
}
