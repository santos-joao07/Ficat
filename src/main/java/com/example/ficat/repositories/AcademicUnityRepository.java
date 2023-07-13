package com.example.ficat.repositories;

import com.example.ficat.models.AcademicUnityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcademicUnityRepository extends JpaRepository<AcademicUnityModel, UUID> {

    @Query("SELECT COUNT(a) > 0 FROM AcademicUnityModel a WHERE a.name = :name")
    boolean existsByName(@Param("name") String name);

    @Query("SELECT COUNT(a) > 0 FROM AcademicUnityModel a WHERE a.acronym = :acronym")
    boolean existsByAcronym(@Param("acronym") String acronym);

}
