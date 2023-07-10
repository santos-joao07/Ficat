package com.example.ficat.dtos;

import jakarta.validation.constraints.NotBlank;

public record CityRecordDto(@NotBlank String name) {
}
