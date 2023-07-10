package com.volunteer.management.controller;

import com.volunteer.management.dto.Volunteer;
import com.volunteer.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RegistrationController {


    RegistrationService registrationService;

    @Autowired
    public void setRegistrationService(RegistrationService service){
        this.registrationService = service;
    }

    @PostMapping("/register")
    public String registerVolunteer(@RequestBody Volunteer volunteer){
        String response = registrationService.registerVolunteer(volunteer);
        return response;
    }
}
