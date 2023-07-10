package com.example.ficat.dtos;

import jakarta.validation.constraints.NotBlank;

public record AcademicUnityRecordDto(@NotBlank String name, @NotBlank String acronym) {
}
