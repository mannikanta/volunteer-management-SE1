package com.volunteer.management.controller;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class RegistrationController {


    RegistrationService registrationService;

    @Autowired
    public void setRegistrationService(RegistrationService service){
        this.registrationService = service;
    }

   /* @PostMapping("/register")
    public Volunteer registerVolunteer(@RequestBody Volunteer volunteer){
        Volunteer response = registrationService.registerVolunteer(volunteer);
        return response;
    }*/

    @PostMapping(value="/register")
    public ModelAndView registerVolunteer(@ModelAttribute("volunteerDto") VolunteerDto volunteer){
        registrationService.registerVolunteer(volunteer);
        return new ModelAndView("Success");
    }


}
