package com.volunteer.management.service;

import com.volunteer.management.dto.Event;

import java.util.List;

public interface EventService {
    public String addEvent(Event event);
    public List<Event> getAllEvents();
}
