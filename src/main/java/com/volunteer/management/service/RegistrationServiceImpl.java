package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.repository.VolunteerRepo;
import com.volunteer.management.utility.RegistrationDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    VolunteerRepo volunteerRepo;

    @Autowired
    RegistrationDtoToEntity dtoToEntity;

    @Override
    public Volunteer registerVolunteer(VolunteerDto volunteerDto) {
       Volunteer volunteer = dtoToEntity.setVolunteerEntity(volunteerDto);
        return volunteerRepo.save(volunteer);
    }


}
