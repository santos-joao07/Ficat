package com.example.ficat.repositories;

import com.example.ficat.models.AcademicUnityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcademicUnityRepository extends JpaRepository<AcademicUnityModel, UUID> {
}
