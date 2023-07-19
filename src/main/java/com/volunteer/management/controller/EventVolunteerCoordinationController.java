package com.volunteer.management.controller;


import com.volunteer.management.dto.ResponseDto;
import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;

import com.volunteer.management.dto.EventVolunteerMatchDto;
import com.volunteer.management.service.EventVolunteerCoordinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EventVolunteerCoordinationController {

    @Autowired
    EventVolunteerCoordinationService coordinationService;

    @Autowired
    ResponseDto responseDto;

    @PostMapping("/sortVolunteers")
    public ModelAndView getVolunteerByDateOfEventCreation(@ModelAttribute("matchDto") EventVolunteerMatchDto eventVolunteerMatchDto, Model model){

        List<VolunteerDto> fetchedVolunteers = coordinationService.fetchVolunteerByDateOfEventCreation(eventVolunteerMatchDto.getEventName(), eventVolunteerMatchDto.getSortVolunteersbyDate());
        String responsePage = null;
        if(fetchedVolunteers.size() == 0){
            responsePage = "Response";
            responseDto.setResponse_Message("No Volunteers found with the provided date");
            model.addAttribute("status", responseDto);

        }else{
            responsePage = "VolunteersList";
            model.addAttribute("listOfVolunteers",fetchedVolunteers);
        }
        return new ModelAndView(responsePage);
    }
}
