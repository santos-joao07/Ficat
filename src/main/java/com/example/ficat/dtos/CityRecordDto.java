package com.example.ficat.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record CityRecordDto(@NotBlank @Column(unique = true) String name) {
}
