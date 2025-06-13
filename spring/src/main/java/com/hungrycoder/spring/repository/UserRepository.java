package com.hungrycoder.spring.repository;

import java.util.Optional; // Import Optional for handling optional values

import com.hungrycoder.spring.models.User; // Import User model
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
