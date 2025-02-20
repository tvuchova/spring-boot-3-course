package com.example.spring_boot_unit_tests.repository;

import com.example.spring_boot_unit_tests.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("update User u set u.name = :newName where u.id = :id")
    void updateUser(Long id, String newName);

    @Modifying
    @Transactional
    @Query("delete from User u where u.id = :id")
    void deleteUser(Long id);

}
