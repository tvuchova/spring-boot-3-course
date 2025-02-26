package com.example.springbootstudentcrud.controller;

import com.example.springbootstudentcrud.repository.GuideRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(GuideController.class)
public class GuideControllerTest {
    @MockitoBean
    GuideRepository guideRepository;
    @Autowired
    private MockMvc mockMvc;


}
