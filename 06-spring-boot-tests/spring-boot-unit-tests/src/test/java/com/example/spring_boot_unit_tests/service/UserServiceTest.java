package com.example.spring_boot_unit_tests.service;


import com.example.spring_boot_unit_tests.model.User;
import com.example.spring_boot_unit_tests.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void testFindAll() {
        List<User> mockUsers = Arrays.asList(new User(1L, "John"), new User(2L, "Jane"));
        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> result = userService.findAll();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());
        verify(userRepository, times(1)).findAll(); // Verify interaction with the mock
    }

    @Test
    void testAddUser() {
        User newUser = new User(3L, "Mark");
        when(userRepository.save(newUser)).thenReturn(newUser);

        User result = userService.addUser(newUser);

        assertNotNull(result);
        assertEquals("Mark", result.getName());
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    void testUpdateUser() {
        long userId = 1L;
        String newName = "UpdatedName";
        User updatedUser = new User(userId, newName);
        doNothing().when(userRepository).updateUser(userId, newName);
        userService.updateUser(userId, newName);

        verify(userRepository, times(1)).updateUser(userId, newName);
    }

    @Test
    void testUpdateUserNotFound() {
        Long userId = 99L;
        String newName = "NonExistentUser";
        doNothing().when(userRepository).updateUser(userId, newName);

        userService.updateUser(userId, newName);

        verify(userRepository, times(1)).updateUser(userId, newName);
    }

    @Test
    void testDeleteUser() {
        long userId = 1L;
        doNothing().when(userRepository).deleteUser(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteUser(userId);
    }

    @Test
    void testDeleteUserNotFound() {
        long userId = 99L;
        doNothing().when(userRepository).deleteUser(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteUser(userId);
    }
}
