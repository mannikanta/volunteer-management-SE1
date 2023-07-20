package com.volunteer.management.service;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.entity.Event;

import java.util.List;

public interface EventService {
    //public String addEvent(Event event);
    public List<EventDto> getAllEvents() throws Exception;

    public String addEvent(EventDto eventDto);
}
