package com.volunteer.management.service;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.entity.Event;
import com.volunteer.management.repository.EventRepo;
import com.volunteer.management.utility.EventDtoToEntity;
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
    EventDtoToEntity dtoToEntity;


//    @Override
//    public String addEvent(Event event) {
//        String message = null;
//        LocalDate eventCreationDate = util.getDate();
//        event.setEventCreationDate(eventCreationDate);
//        try {
//           eventRepo.save(event);
//           message = "Event Created Successfully";
//        }catch (Exception e){
//            message = e.getMessage();
//        }
//        return message;
//    }



    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public String addEvent(EventDto eventDto) {
        String response = "";
        try {
            Event event = dtoToEntity.setEventEntityData(eventDto);
            eventRepo.save(event);
            response = "Event added";
        }catch (Exception e){
            response = "Event not added "+" "+e.getMessage();
        }
        return response;
    }
}
