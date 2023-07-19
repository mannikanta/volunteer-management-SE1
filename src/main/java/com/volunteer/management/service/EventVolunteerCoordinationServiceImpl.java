package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Event;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.repository.EventRepo;
import com.volunteer.management.repository.VolunteerRepo;
import com.volunteer.management.utility.VolunteerEntityToDto;
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

    @Autowired
    VolunteerEntityToDto entityToDto;

    @Override
    public List<VolunteerDto> fetchVolunteerByDateOfEventCreation(String eventName, String beforeOrAfter) {
        Event event = eventRepo.findByEventName(eventName);
//        List<Volunteer> existingVolunteers = new ArrayList<>();
//        List<Volunteer> newVolunteers = new ArrayList<>();
        List<Volunteer> fetchedVolunteers = new ArrayList<>();
        List<Volunteer> allVolunteers = volunteerRepo.findAll();
        List<VolunteerDto> dtoList = new ArrayList<>();
        for(int i = 0; i < allVolunteers.size(); i++){
            if(allVolunteers.get(i).getVolunteerRegistrationDate().compareTo(event.getEventCreationDate()) < 0 && beforeOrAfter.toLowerCase().equals("before")){
                fetchedVolunteers.add(allVolunteers.get(i));

            }else if(allVolunteers.get(i).getVolunteerRegistrationDate().compareTo(event.getEventCreationDate()) >= 0 && beforeOrAfter.toLowerCase().equals("after")){
                 fetchedVolunteers.add(allVolunteers.get(i));
            }
        }
        if(fetchedVolunteers.size() == 0){
            return dtoList;
        }else {
          dtoList = entityToDto.convertEntityToDto(fetchedVolunteers);
        }

       return dtoList;
    }
}
