package com.volunteer.management.controller;

import com.volunteer.management.dto.ResponseDto;
import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @Autowired
    ResponseDto responseDto;


   /* @PostMapping("/register")
    public Volunteer registerVolunteer(@RequestBody Volunteer volunteer){
        Volunteer response = registrationService.registerVolunteer(volunteer);
        return response;
    }*/

    @PostMapping(value="/register")
    public ModelAndView registerVolunteer(@ModelAttribute("volunteerDto") VolunteerDto volunteer, Model model){
        try {
            Volunteer dto = registrationService.registerVolunteer(volunteer);
            if (dto == null) {
                responseDto.setResponse_Message("volunteer registration Failed");
            }else{
                responseDto.setResponse_Message("Volunteer Registered successfully with volunteer User Id "+dto.getVolunteerId());
            }

        }catch (Exception e){
            responseDto.setResponse_Message("volunteer registration Failed");

        }
        model.addAttribute("status", responseDto);
        return new ModelAndView("Response");
    }


}
