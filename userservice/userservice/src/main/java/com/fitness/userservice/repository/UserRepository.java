package com.fitness.userservice.repository;
import com.fitness.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
public User findByEmail(String email);
public boolean existsByEmail(String email);
public boolean existsByKeycloakId(String keycloakId);

}
