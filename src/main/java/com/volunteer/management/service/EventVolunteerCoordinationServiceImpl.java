package com.volunteer.management.service;

import com.volunteer.management.dto.Event;
import com.volunteer.management.dto.Volunteer;
import com.volunteer.management.repository.EventRepo;
import com.volunteer.management.repository.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventVolunteerCoordinationServiceImpl implements EventVolunteerCoordinationService{

    @Autowired
    EventRepo eventRepo;

    @Autowired
    VolunteerRepo volunteerRepo;

    @Override
    public List<Volunteer> fetchVolunteerByDateOfEventCreation(String eventName) {
        Event event = eventRepo.findByEventName(eventName);
        System.out.println(event.getEventName()+" "+event.getEventLocation()+" "+event.getEventDescription()+" "+event.getEventCreationDate());
        return null;
    }
}
