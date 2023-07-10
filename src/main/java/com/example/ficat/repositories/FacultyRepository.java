package com.example.ficat.repositories;

import com.example.ficat.models.FacultyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyModel, UUID> {
}
