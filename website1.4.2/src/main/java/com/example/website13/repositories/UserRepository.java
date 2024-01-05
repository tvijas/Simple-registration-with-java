package com.example.website13.repositories;

import com.example.website13.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByLoginAndPasswordAndRegistrationFinishedIsTrue(String login, String password);
    @Modifying
    @Query("UPDATE userdata e SET e.registrationFinished = true WHERE e.email = :email")
    int updateRegistrationFinishedByEmail(@Param("email")String email);
}
