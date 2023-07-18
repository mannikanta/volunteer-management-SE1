package com.volunteer.management.utility;

import com.volunteer.management.dto.VolunteerEventEnrollmentDto;
import com.volunteer.management.entity.Event;
import com.volunteer.management.entity.EventVolunteerRelation;
import com.volunteer.management.entity.Volunteer;
import org.springframework.stereotype.Component;

@Component
public class EnrollDtoToEntity {

    public EventVolunteerRelation EnrollmentDtoToEntity(VolunteerEventEnrollmentDto enrollmentDto) {
        EventVolunteerRelation relation = new EventVolunteerRelation();
        relation.setVolunteerId(enrollmentDto.getVolunteerId());
        relation.setEventName(enrollmentDto.getEventName());
        return relation;
    }

}
