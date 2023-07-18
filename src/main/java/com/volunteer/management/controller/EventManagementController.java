package com.volunteer.management.controller;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.dto.ResponseDto;
import com.volunteer.management.entity.Event;
import com.volunteer.management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EventManagementController {

        @Autowired
        EventService eventService;

        @Autowired
        ResponseDto responseDto;


//        @PostMapping("/addEvent")
//        public String addEvent(@RequestBody Event event){
//                String status = eventService.addEvent(event);
//                return status;
//        }

        @PostMapping("/addEvent")
        public ModelAndView addEvent(@ModelAttribute("eventDto") EventDto eventDto, Model model){
                String response = eventService.addEvent(eventDto);
                responseDto.setResponse_Message(response);
                model.addAttribute("status", responseDto);
                return new ModelAndView("Response");
        }

        @GetMapping("/getAllEvents")
        public ModelAndView getAllEvents(Model model){
                List<EventDto> eventsList = eventService.getAllEvents();
                model.addAttribute("events",eventsList);
               return new ModelAndView("EventsList");
        }
}
