package com.example.ficat.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="AcademicUnities")
public class AcademicUnityModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idAcademicUnity;
    private String name;
    private String acronym;

    public UUID getIdAcademicUnity() {
        return idAcademicUnity;
    }

    public void setIdAcademicUnity(UUID idAcademicUnity) {
        this.idAcademicUnity = idAcademicUnity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
