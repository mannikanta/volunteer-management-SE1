package com.volunteer.management.controller;

import com.volunteer.management.dto.ResponseDto;
import com.volunteer.management.dto.VolunteerEventEnrollmentDto;
import com.volunteer.management.service.VolunteerEventEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EventEnrollmentController {

    @Autowired
    VolunteerEventEnrollmentService enrollmentService;

    @Autowired
    ResponseDto responseDto;

    @PostMapping("/enroll")
    public ModelAndView enroll(@ModelAttribute("enrollDto") VolunteerEventEnrollmentDto enrollmentDto, Model model) throws Exception {
       String response = enrollmentService.enrollForEvent(enrollmentDto);
       responseDto.setResponse_Message(response);
        model.addAttribute("status", responseDto);
        return new ModelAndView("Response");
    }
}
