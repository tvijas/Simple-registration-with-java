package com.example.website13.repositories;

import com.example.website13.models.VerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VerificationRepository extends JpaRepository<VerificationEntity, Integer> {
    Optional<VerificationEntity> findByEmailAndCode(String email, int vcode);
}
