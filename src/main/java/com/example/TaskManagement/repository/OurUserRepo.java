package com.example.TaskManagement.repository;

import com.example.TaskManagement.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OurUserRepo extends JpaRepository<OurUsers, Integer> {
    Optional<OurUsers>findByEmail(String email);
}
