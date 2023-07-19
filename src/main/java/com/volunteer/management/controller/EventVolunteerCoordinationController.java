package com.volunteer.management.controller;


import com.volunteer.management.dto.ResponseDto;
import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;

import com.volunteer.management.dto.EventVolunteerMatchDto;
import com.volunteer.management.service.EventVolunteerCoordinationService;
import com.volunteer.management.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class EventVolunteerCoordinationController {

    @Autowired
    EventVolunteerCoordinationService coordinationService;

    @Autowired
    ResponseDto responseDto;

    @Autowired
    MailSenderService mailSenderService;

    @PostMapping("/sortVolunteers")
    public ModelAndView getVolunteerByDateOfEventCreation(@ModelAttribute("matchDto") EventVolunteerMatchDto eventVolunteerMatchDto, Model model){

        List<VolunteerDto> fetchedVolunteers = coordinationService.fetchVolunteerByDateOfEventCreation(eventVolunteerMatchDto.getEventName(), eventVolunteerMatchDto.getSortVolunteersbyDate());
        String responsePage = null;
        if(fetchedVolunteers.size() == 0){
            responsePage = "Response";
            responseDto.setResponse_Message("No Volunteers found with the provided date");
            model.addAttribute("status", responseDto);

        }else{
            if(eventVolunteerMatchDto.getSortVolunteersbyDate().equals("after")){
                responsePage = "VolunteersList";
                model.addAttribute("listOfVolunteers", fetchedVolunteers);
            }else if(eventVolunteerMatchDto.getSortVolunteersbyDate().equals("before")){
                responsePage = "VolunteerListBefore";
                model.addAttribute("listOfVolunteers", fetchedVolunteers);
            }
        }
        return new ModelAndView(responsePage);
    }

//    @PostMapping("/sendMail")
//    public void sendMailToVolunteer(@ModelAttribute("volunteerDto") VolunteerDto volunteerDto, Model model){
//        System.out.println("Execution is here");
//        System.out.println(volunteerDto.getVolunteerId());
//    }


    @PostMapping("/sendMail")
    public void sendMailToVolunteer(@ModelAttribute("volunteerDto") VolunteerDto volunteerDto, Model model, HttpServletRequest request) {
        String[] selectedVolunteers = request.getParameterValues("selectedVolunteers");

        if (selectedVolunteers != null) {
            for (String volunteerEmailAddress : selectedVolunteers) {
                volunteerDto.setEmailAddress(volunteerEmailAddress);
                String volunteerEmail = volunteerDto.getEmailAddress();
                mailSenderService.sendSimpleEmail( volunteerEmail,"volunteer Availability Check","Hello Volunteer! \n are you interested in joining the event Camp");

            }
        }
    }

}
