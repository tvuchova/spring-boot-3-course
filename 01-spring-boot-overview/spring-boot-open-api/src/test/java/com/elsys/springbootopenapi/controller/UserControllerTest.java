package com.elsys.springbootopenapi.controller;

import com.elsys.springbootopenapi.model.User;
import com.elsys.springbootopenapi.service.UserService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFindAll() throws Exception {
        var users = Arrays.asList(
                new User(1, "John"),
                new User(2, "Jane")
        );
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("John")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Jane")));

        verify(userService, times(1)).findAll();
    }

    @Test
    void testAddUser() throws Exception {
        var newUser = new User(3, "Mark");
        when(userService.addUser(Mockito.any(User.class))).thenReturn(newUser);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("Mark")));

        verify(userService, times(1)).addUser(Mockito.any(User.class));
    }

    @Test
    void testUpdateUser() throws Exception {
        int userId = 1;
        String newName = "UpdatedName";
        var updatedUser = new User(userId, newName);
        when(userService.updateUser(userId, newName)).thenReturn(updatedUser);

        mockMvc.perform(put("/users/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                .queryParam("newName", newName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("UpdatedName")));

        verify(userService, times(1)).updateUser(userId, newName);
    }

    @Test
    void testDeleteUser() throws Exception {
        // Arrange
        int userId = 1;
        when(userService.deleteUser(userId)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(delete("/users/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(userService, times(1)).deleteUser(userId);
    }
}
