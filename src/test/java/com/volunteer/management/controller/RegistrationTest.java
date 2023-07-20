package com.volunteer.management.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.service.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class RegistrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private RegistrationService registrationService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testRegisterVolunteer_Success() throws Exception {
        // Mock the registrationService behavior
        VolunteerDto volunteerDto = new VolunteerDto(); // Add required data for testing
        Volunteer mockedVolunteer = new Volunteer(); // Add required data for testing
        when(registrationService.registerVolunteer(any(VolunteerDto.class))).thenReturn(mockedVolunteer);

        // Perform the POST request to the /register endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/register").flashAttr("volunteerDto", volunteerDto)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("Response")).andExpect(MockMvcResultMatchers.model().attributeExists("status"));

        // Add more assertions based on your specific logic and data
    }

    @Test
    public void testRegisterVolunteer_Failure() throws Exception {
        // Mock the registrationService behavior to throw an exception
        VolunteerDto volunteerDto = new VolunteerDto(); // Add required data for testing
        when(registrationService.registerVolunteer(any(VolunteerDto.class))).thenThrow(new RuntimeException());

        // Perform the POST request to the /register endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/register").flashAttr("volunteerDto", volunteerDto)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("Response")).andExpect(MockMvcResultMatchers.model().attributeExists("status"));

        // Add more assertions based on your specific logic and data
    }
}

