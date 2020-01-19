package com.example.batch.process.BatchProcess.repository;

import com.example.batch.process.BatchProcess.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
