package com.volunteer.management.controller;


import com.volunteer.management.entity.Volunteer;

import com.volunteer.management.dto.EventVolunteer;
import com.volunteer.management.service.EventVolunteerCoordinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventVolunteerCoordinationController {

    @Autowired
    EventVolunteerCoordinationService coordinationService;

    @PostMapping("/sortVolunteers")
    public List<Volunteer> getVolunteerByDateOfEventCreation(@RequestBody EventVolunteer eventVolunteer){
        coordinationService.fetchVolunteerByDateOfEventCreation(eventVolunteer.getEventName());
        return null;
    }
}
