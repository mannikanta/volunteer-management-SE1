package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;


public interface RegistrationService {
    public Volunteer registerVolunteer(VolunteerDto volunteer);
}
