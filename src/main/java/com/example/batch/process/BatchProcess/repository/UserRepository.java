package com.example.batch.process.BatchProcess.repository;

import com.example.batch.process.BatchProcess.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
