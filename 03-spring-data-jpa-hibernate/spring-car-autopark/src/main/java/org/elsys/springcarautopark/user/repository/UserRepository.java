package org.elsys.springcarautopark.user.repository;

import org.elsys.springcarautopark.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String username);

    Optional<User> findByName(String name);

    // JPQL Example
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> findUsersByName(@Param("name") String name);

    // Native SQL Example
    @Query(value = "SELECT * FROM users WHERE email LIKE %:email%", nativeQuery = true)
    List<User> findUsersByEmail(@Param("email") String email);
}
