package com.volunteer.management.service;

import com.volunteer.management.entity.Event;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.repository.EventRepo;
import com.volunteer.management.repository.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Volunteer> existingVolunteers = new ArrayList<>();
        List<Volunteer> newVolunteers = new ArrayList<>();
        List<Volunteer> allVolunteers = volunteerRepo.findAll();
        for(int i = 0; i < allVolunteers.size(); i++){
            if(allVolunteers.get(i).getVolunteerRegistrationDate().compareTo(event.getEventCreationDate()) < 0){
                existingVolunteers.add(allVolunteers.get(i));
                System.out.println("hae existing volunteer are you interested");
            }else if(allVolunteers.get(i).getVolunteerRegistrationDate().compareTo(event.getEventCreationDate()) >= 0){
                 newVolunteers.add(allVolunteers.get(i));
                System.out.println("hae new volunteer");
            }
        }
        System.out.println(event.getEventName()+" "+event.getEventLocation()+" "+event.getEventDescription()+" "+event.getEventCreationDate());
        return null;
    }
}
