package com.volunteer.management.service;

import com.volunteer.management.dto.Volunteer;

import java.util.List;

public interface EventVolunteerCoordinationService {

    public List<Volunteer> fetchVolunteerByDateOfEventCreation(String eventName);
}
