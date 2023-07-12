package com.volunteer.management.service;

import com.volunteer.management.dto.Volunteer;
import com.volunteer.management.repository.VolunteerRepo;
import com.volunteer.management.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    VolunteerRepo volunteerRepo;

    @Autowired
    Utility util;

    @Override
    public Volunteer registerVolunteer(Volunteer volunteer) {
        volunteer.setVolunteerRegistrationDate(util.getDate());
        return volunteerRepo.save(volunteer);
    }


}
