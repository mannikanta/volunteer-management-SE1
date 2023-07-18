package com.volunteer.management.controller;

import com.volunteer.management.dto.VolunteerEventEnrollmentDto;
import com.volunteer.management.service.VolunteerEventEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventEnrollmentController {

    @Autowired
    VolunteerEventEnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public String enroll(@ModelAttribute("enrollDto") VolunteerEventEnrollmentDto enrollmentDto){
        enrollmentService.enrollForEvent(enrollmentDto);
        return null;
    }
}
