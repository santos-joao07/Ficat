package com.example.ficat.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record KnowledgeAreaRecordDto(@NotNull Long code, @NotBlank String description) {
}
