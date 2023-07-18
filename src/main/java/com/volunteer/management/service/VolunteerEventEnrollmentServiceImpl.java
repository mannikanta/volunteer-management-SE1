package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerEventEnrollmentDto;
import com.volunteer.management.entity.EventVolunteerRelation;
import com.volunteer.management.repository.EventVolunteerRepo;
import com.volunteer.management.utility.EnrollDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerEventEnrollmentServiceImpl implements VolunteerEventEnrollmentService{

    @Autowired
    EventVolunteerRepo eventVolunteerRepo;

    @Autowired
    EnrollDtoToEntity dtoToEntity;

    @Override
    public String enrollForEvent(VolunteerEventEnrollmentDto enrollmentDto) {
        EventVolunteerRelation enroll = dtoToEntity.EnrollmentDtoToEntity(enrollmentDto);
        eventVolunteerRepo.save(enroll);
        return null;
    }
}
