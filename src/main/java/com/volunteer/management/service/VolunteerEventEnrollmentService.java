package com.volunteer.management.service;

import com.volunteer.management.dto.VolunteerEventEnrollmentDto;

public interface VolunteerEventEnrollmentService {

    public String enrollForEvent(VolunteerEventEnrollmentDto enrollmentDto) throws Exception;
}
