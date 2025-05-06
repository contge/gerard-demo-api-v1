package com.gerard.gerard_demo_api_v1.repository;

import com.gerard.gerard_demo_api_v1.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    // Usando @Query (JPQL)
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> buscarPorEmail(@Param("email") String email);

    // Usando SQL nativo
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<User> buscarPorEmailNativo(@Param("email") String email);
}
