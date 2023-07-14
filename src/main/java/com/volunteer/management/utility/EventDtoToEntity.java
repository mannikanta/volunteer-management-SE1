package com.volunteer.management.utility;

import com.volunteer.management.dto.EventDto;
import com.volunteer.management.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Component
public class EventDtoToEntity {

    Utility util;

    @Autowired
    public void setUtility(Utility utility){
        this.util = utility;
    }

    public Event setEventEntityData(EventDto eventDto){
        Event event = new Event();
        event.setEventName(eventDto.getEventName());
        event.setEventDescription(eventDto.getEventDescription());
        event.setEventLocation(eventDto.getEventLocation());
        event.setEventDateTime(Date.valueOf(eventDto.getEventDateTime()));
        event.setEventDuration(eventDto.getEventDuration());
        event.setVolunteer(Boolean.parseBoolean(eventDto.getExistingVolunteer()));
        event.setEventCreationDate(util.getDate());
        return event;
    }

    public EventDto setEventDtoData(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setEventName(event.getEventName());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setEventLocation(event.getEventLocation());
        eventDto.setEventDateTime(event.getEventDateTime().toString());
        eventDto.setEventDuration(event.getEventDuration());
        return eventDto;
    }
}
