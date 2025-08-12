package com.starter.springboot.repository;
import com.starter.springboot.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {
    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findByEmail (String email);

    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
