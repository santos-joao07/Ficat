package com.example.ficat.repositories;

import com.example.ficat.models.KnowledgeAreaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KnowledgeAreaRepository extends JpaRepository<KnowledgeAreaModel, UUID> {
}
