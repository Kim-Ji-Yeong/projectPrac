package com.example.projectprac.repository;

import com.example.projectprac.domain.dto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
