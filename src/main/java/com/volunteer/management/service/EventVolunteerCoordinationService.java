package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerDto;

import java.util.List;

public interface EventVolunteerCoordinationService {

    public List<VolunteerDto> fetchVolunteerByDateOfEventCreation(String eventName, String beforeOrAfter);
}
