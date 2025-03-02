package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.GuideRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(GuideController.class)
public class GuideControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	GuideRepository guideRepository;
	
	
	@Test
	public void testAddGuidePostMethodWorks() throws Exception {
		mockMvc.perform(post("/addguide")
		.param("name", "David")
		.param("salary", "50000"))
		.andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/allstudents"));
	}
	

}
