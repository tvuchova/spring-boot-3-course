package com.elsys.springbootopenapi.service;

import com.elsys.springbootopenapi.model.User;
import com.elsys.springbootopenapi.repository.UserRepository;
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
        List<User> mockUsers = Arrays.asList(new User(1, "John"), new User(2, "Jane"));
        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> result = userService.findAll();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());
        verify(userRepository, times(1)).findAll(); // Verify interaction with the mock
    }

    @Test
    void testAddUser() {
        User newUser = new User(3, "Mark");
        when(userRepository.addUser(newUser)).thenReturn(newUser);

        User result = userService.addUser(newUser);

        assertNotNull(result);
        assertEquals("Mark", result.getName());
        verify(userRepository, times(1)).addUser(newUser);
    }

    @Test
    void testUpdateUser() {
        int userId = 1;
        String newName = "UpdatedName";
        User updatedUser = new User(userId, newName);
        when(userRepository.updateUser(userId, newName)).thenReturn(Optional.of(updatedUser));

        User result = userService.updateUser(userId, newName);

        assertNotNull(result);
        assertEquals("UpdatedName", result.getName());
        verify(userRepository, times(1)).updateUser(userId, newName);
    }

    @Test
    void testUpdateUserNotFound() {
        int userId = 99;
        String newName = "NonExistentUser";
        when(userRepository.updateUser(userId, newName)).thenReturn(Optional.empty());

        User result = userService.updateUser(userId, newName);

        assertNull(result);
        verify(userRepository, times(1)).updateUser(userId, newName);
    }

    @Test
    void testDeleteUser() {
        int userId = 1;
        when(userRepository.deleteUser(userId)).thenReturn(true);

        boolean result = userService.deleteUser(userId);

        assertTrue(result);
        verify(userRepository, times(1)).deleteUser(userId);
    }

    @Test
    void testDeleteUserNotFound() {
        int userId = 99;
        when(userRepository.deleteUser(userId)).thenReturn(false);

        boolean result = userService.deleteUser(userId);

        assertFalse(result);
        verify(userRepository, times(1)).deleteUser(userId);
    }
}