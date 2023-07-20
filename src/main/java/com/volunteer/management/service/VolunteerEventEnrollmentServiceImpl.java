package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerEventEnrollmentDto;
import com.volunteer.management.entity.Event;
import com.volunteer.management.entity.EventVolunteerRelation;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.repository.EventRepo;
import com.volunteer.management.repository.EventVolunteerRepo;
import com.volunteer.management.repository.VolunteerRepo;
import com.volunteer.management.utility.EnrollDtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerEventEnrollmentServiceImpl implements VolunteerEventEnrollmentService{

    @Autowired
    EventVolunteerRepo eventVolunteerRepo;

    @Autowired
    EnrollDtoToEntity dtoToEntity;

    @Autowired
    VolunteerRepo volunteerRepo;

    @Autowired
    EventRepo eventRepo;

    @Override
    public String enrollForEvent(VolunteerEventEnrollmentDto enrollmentDto) throws Exception {
        String response = null;
        EventVolunteerRelation enroll = dtoToEntity.EnrollmentDtoToEntity(enrollmentDto);
        if(volunteerRepo.findByVolunteerId(enroll.getVolunteerId()) == null){
            response = "No Volunteer Found";
        }else if(eventRepo.findByEventName(enroll.getEventName()) == null){
            response = "No Event found with the provided event name";
        }else{
            try {
                eventVolunteerRepo.save(enroll);
                response = "Volunteer Registered to event successfully";
            }catch (Exception e){
                throw new Exception("Oops Some thing went wrong!!!!");
            }
        }

        return response;
    }
}
