package com.example.ficat.repositories;

import com.example.ficat.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query("SELECT COUNT(u) > 0 FROM UserModel u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
