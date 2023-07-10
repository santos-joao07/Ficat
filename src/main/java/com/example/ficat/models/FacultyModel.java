package com.example.ficat.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Faculties")
public class FacultyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idFaculty;
    private String name;

    public UUID getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(UUID idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
