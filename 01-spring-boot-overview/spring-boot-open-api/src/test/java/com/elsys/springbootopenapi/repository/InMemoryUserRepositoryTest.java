package com.elsys.springbootopenapi.repository;

import com.elsys.springbootopenapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class InMemoryUserRepositoryTest {
    private InMemoryUserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new InMemoryUserRepository();
    }

    @Test
    void testFindAll() {
        List<User> users = userRepository.findAll();

        assertThat(users).isNotEmpty();
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getName()).isEqualTo("John Doe");
    }

    @Test
    void testAddUser() {
        User newUser = new User(1, "Jane Doe");

        User addedUser = userRepository.addUser(newUser);
        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(2);
        assertThat(addedUser).isEqualTo(newUser);
        assertThat(users).extracting(User::getName).contains("Jane Doe");
    }

    @Test
    void testUpdateUser() {
        int userId = 0;
        String newName = "John Smith";


        Optional<User> updatedUser = userRepository.updateUser(userId, newName);
        List<User> users = userRepository.findAll();


        assertThat(updatedUser).isPresent();
        assertThat(updatedUser.get().getName()).isEqualTo(newName);
        assertThat(users).extracting(User::getName).containsExactly(newName);
    }

    @Test
    void testUpdateNonExistentUser() {

        Optional<User> updatedUser = userRepository.updateUser(999, "Nonexistent");

        assertThat(updatedUser).isNotPresent();
    }

    @Test
    void testDeleteUser() {

        int userId = 0;

        boolean deleted = userRepository.deleteUser(userId);
        List<User> users = userRepository.findAll();

        assertThat(deleted).isTrue();
        assertThat(users).isEmpty();
    }

    @Test
    void testDeleteNonExistentUser() {
        boolean deleted = userRepository.deleteUser(999);

        assertThat(deleted).isFalse();
    }
}
