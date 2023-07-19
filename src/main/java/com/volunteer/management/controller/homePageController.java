package com.volunteer.management.controller;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.dto.EventVolunteerMatchDto;
import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.dto.VolunteerEventEnrollmentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class homePageController {

    @GetMapping("/home")
    public ModelAndView displayHomePage(){
        return new ModelAndView("homePage");

    }

    @GetMapping("/adminHome")
    public ModelAndView displayAdminHomePage(){
        return new ModelAndView("adminHomePage");

    }

    @GetMapping("/registrationPage")
    public ModelAndView showRegistrationPage(){
       return new ModelAndView("registration");
    }

    // belongs to admin
    @GetMapping("/eventAdd")
    public ModelAndView showAddEventPage(){
        return new ModelAndView("EventPage");
    }

    @GetMapping("/admin/home")
    public ModelAndView showAdminHomePage(){
        return new ModelAndView("adminHomePage");
    }

    @GetMapping("/eventVolunteerMatch")
    public ModelAndView showEventVolunteerMatchPage(){
        return new ModelAndView("EventVolunteerMatch");
    }

    @ModelAttribute("eventDto")
    public EventDto addEventDto(){
        return new EventDto();
    }

    @ModelAttribute("volunteerDto")
    public VolunteerDto volunteerRegistrationDto(){
        return new VolunteerDto();
    }

    @GetMapping("/enrollPage")
    public ModelAndView enrollPage(){
        return new ModelAndView("Enroll");
    }

    @ModelAttribute("enrollDto")
    public VolunteerEventEnrollmentDto volunteerEnrollmentDto(){
        return new VolunteerEventEnrollmentDto();
    }

    @ModelAttribute("matchDto")
    public EventVolunteerMatchDto matchDto(){
        return new EventVolunteerMatchDto();
    }

}
