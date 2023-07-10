package com.volunteer.management.service;

import com.volunteer.management.dto.Volunteer;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Override
    public String registerVolunteer(Volunteer volunteer) {
        System.out.println(volunteer.toString());
        return volunteer.toString();
    }
}
