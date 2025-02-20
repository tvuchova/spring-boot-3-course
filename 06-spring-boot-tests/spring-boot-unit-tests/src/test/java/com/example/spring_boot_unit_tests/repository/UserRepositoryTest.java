package com.example.spring_boot_unit_tests.repository;


import com.example.spring_boot_unit_tests.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(null, "Alice");
        user = userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void testUpdateUser() {
        userRepository.updateUser(user.getId(), "Updated Alice");
        entityManager.clear();

        User updatedUser = userRepository.findById(user.getId()).orElseThrow();
        assertThat(updatedUser.getName()).isEqualTo("Updated Alice");
    }

    @Test
    void testDeleteUser() {

        long userId = 1L;


        userRepository.deleteUser(userId);
        userRepository.deleteUser(user.getId());

        List<User> users = userRepository.findAll();

        //assertThat(deleted).isTrue();
        assertThat(users).isEmpty();
    }

    @Test
    void testFindAll() {
        List<User> users = userRepository.findAll();

        assertThat(users).isNotEmpty();
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getName()).isEqualTo("Alice");
    }

    @Test
    void testAddUser() {
        User newUser = new User(null, "Jane Doe");

        User addedUser = userRepository.save(newUser);
        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(2);
        assertThat(addedUser).isEqualTo(newUser);
        assertThat(users).extracting(User::getName).contains("Jane Doe");
    }

    /* @Test
     void testUpdateUser() {
         int userId = 0;
         String newName = "John Smith";


         Optional<User> updatedUser = userRepository.updateUser(userId, newName);
         List<User> users = userRepository.findAll();


         assertThat(updatedUser).isPresent();
         assertThat(updatedUser.get().getName()).isEqualTo(newName);
         assertThat(users).extracting(User::getName).containsExactly(newName);
     }
 */
    @Test
    void testUpdateNonExistentUser() {

        userRepository.updateUser(999L, "Nonexistent");

        //assertThat(updatedUser).isNotPresent();
    }

    /*@Test
    void testDeleteUser() {

        int userId = 0;

        boolean deleted = userRepository.deleteUser(userId);
        List<User> users = userRepository.findAll();

        assertThat(deleted).isTrue();
        assertThat(users).isEmpty();
    }*/

    @Test
    void testDeleteNonExistentUser() {
        userRepository.deleteUser(999L);

        //assertThat(deleted).isFalse();
    }
}
