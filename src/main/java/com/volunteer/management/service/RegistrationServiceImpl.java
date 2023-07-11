package com.volunteer.management.service;

import com.volunteer.management.dto.Volunteer;
import com.volunteer.management.repository.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    VolunteerRepo volunteerRepo;

    @Override
    public Volunteer registerVolunteer(Volunteer volunteer) {
        return volunteerRepo.save(volunteer);
    }


}
