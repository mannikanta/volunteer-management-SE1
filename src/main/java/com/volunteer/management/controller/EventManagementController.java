package com.volunteer.management.controller;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.entity.Event;
import com.volunteer.management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EventManagementController {

        @Autowired
        EventService eventService;

//        @PostMapping("/addEvent")
//        public String addEvent(@RequestBody Event event){
//                String status = eventService.addEvent(event);
//                return status;
//        }

        @PostMapping("/addEvent")
        public ModelAndView addEvent(@ModelAttribute("eventDto") EventDto eventDto){
                String response = eventService.addEvent(eventDto);
                // change return statement
                System.out.println(response);
                return new ModelAndView("Success");
        }

        @GetMapping("/getAllEvents")
        public ModelAndView getAllEvents(Model model){
                List<EventDto> eventsList = eventService.getAllEvents();
                model.addAttribute("events",eventsList);
               return new ModelAndView("EventsList");
        }
}
