package com.volunteer.management.service;

import com.volunteer.management.dto.Event;
import com.volunteer.management.repository.EventRepo;
import com.volunteer.management.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    EventRepo eventRepo;

    @Autowired
    Utility util;


    @Override
    public String addEvent(Event event) {
        String message = null;
        LocalDate eventCreationDate = util.getDate();
        event.setEventCreationDate(eventCreationDate);
        try {
           eventRepo.save(event);
           message = "Event Created Successfully";
        }catch (Exception e){
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}
