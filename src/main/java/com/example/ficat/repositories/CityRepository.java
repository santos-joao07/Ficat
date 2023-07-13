package com.example.ficat.repositories;

import com.example.ficat.models.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityModel, UUID> {

    @Query("SELECT COUNT(c) > 0 FROM CityModel c WHERE c.name = :name")
    boolean existsByName(@Param("name") String name);
}
