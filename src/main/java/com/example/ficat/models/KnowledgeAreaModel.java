package com.example.ficat.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="KnowledgeAreas")
public class KnowledgeAreaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idKnowledgeArea;
    private Long code;
    private String description;

    public UUID getIdKnowledgeArea() {
        return idKnowledgeArea;
    }

    public void setIdKnowledgeArea(UUID idKnowledgeArea) {
        this.idKnowledgeArea = idKnowledgeArea;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
