package com.volunteer.management.controller;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.dto.VolunteerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class homePage {

    @GetMapping("/home")
    public ModelAndView displayHomePage(){
        return new ModelAndView("homePage");

    }

    @GetMapping("/registrationPage")
    public ModelAndView showRegistrationPage(){
       return new ModelAndView("registration");
    }

    @GetMapping("/eventAdd")
    public ModelAndView showAddEventPage(){
        return new ModelAndView("EventPage");
    }

    @ModelAttribute("eventDto")
    public EventDto addEventDto(){
        return new EventDto();
    }

    @ModelAttribute("volunteerDto")
    public VolunteerDto volunteerRegistrationDto(){
        return new VolunteerDto();
    }


}
