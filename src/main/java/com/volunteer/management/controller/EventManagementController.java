package com.volunteer.management.controller;

import com.volunteer.management.dto.Event;
import com.volunteer.management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventManagementController {

        @Autowired
        EventService eventService;

        @PostMapping("/addEvent")
        public String addEvent(@RequestBody Event event){
                String status = eventService.addEvent(event);
                return status;
        }

        @GetMapping("/getAllEvents")
        public List<Event> getAllEvents(){
               return eventService.getAllEvents();
        }
}
