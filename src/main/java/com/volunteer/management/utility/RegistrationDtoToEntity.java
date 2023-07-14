package com.volunteer.management.utility;

import com.volunteer.management.dto.VolunteerDto;
import com.volunteer.management.entity.Volunteer;
import com.volunteer.management.entity.VolunteerContactDetails;
import com.volunteer.management.entity.VolunteerPersonalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Arrays;

@Component
public class RegistrationDtoToEntity {

    Utility util;

    @Autowired
    public void setUtility(Utility utility){
        this.util = utility;
    }

    public Volunteer setVolunteerEntity(VolunteerDto volunteerDto){
        Volunteer volunteerEntity = new Volunteer();
        volunteerEntity.setVolunteerId(volunteerDto.getVolunteerId());

        VolunteerPersonalDetails personalDetails = new VolunteerPersonalDetails();
        personalDetails.setVolunteerFirstName(volunteerDto.getVolunteerFirstName());
        personalDetails.setVolunteerLastName(volunteerDto.getVolunteerLastName());
        personalDetails.setAddress(volunteerDto.getAddress());
        volunteerEntity.setPersonalDetails(personalDetails);

        VolunteerContactDetails contactDetails = new VolunteerContactDetails();
        contactDetails.setDateOfBirth(Date.valueOf(volunteerDto.getDateOfBirth()));
        contactDetails.setPhoneNumber(volunteerDto.getPhoneNumber());
        contactDetails.setEmailAddress(volunteerDto.getEmailAddress());
        contactDetails.setGender(volunteerDto.getGender());
        contactDetails.setVolunteerAvailability(Date.valueOf(volunteerDto.getVolunteerAvailability()));
        contactDetails.setSkillSet(Arrays.asList(volunteerDto.getSkillSet()));
        volunteerEntity.setContactDetails(contactDetails);
        volunteerEntity.setVolunteerRegistrationDate(util.getDate());

        return volunteerEntity;
    }
}
