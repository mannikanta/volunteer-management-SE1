package com.volunteer.management.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class EventManagementTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Test
    public void testAddEvent_Success() throws Exception {
        // Mock the eventService behavior
        EventDto eventDto = new EventDto(); // Add required data for testing
        when(eventService.addEvent(any(EventDto.class))).thenReturn("Event added successfully");

        // Perform the POST request to the /addEvent endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/addEvent")
                        .flashAttr("eventDto", eventDto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Response"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("status"))
                .andExpect(MockMvcResultMatchers.model().attribute("status", "Event added successfully"));
    }

    @Test
    public void testAddEvent_Failure() throws Exception {
        // Mock the eventService behavior to return failure response
        EventDto eventDto = new EventDto(); // Add required data for testing
        when(eventService.addEvent(any(EventDto.class))).thenReturn("Event addition failed");

        // Perform the POST request to the /addEvent endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/addEvent")
                        .flashAttr("eventDto", eventDto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("Response"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("status"))
                .andExpect(MockMvcResultMatchers.model().attribute("status", "Event addition failed"));
    }
}

