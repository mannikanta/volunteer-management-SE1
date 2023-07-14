package com.volunteer.management.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VolunteerDto {

    private Long id;
    private String volunteerId;

    private String volunteerFirstName;
    private String volunteerLastName;
    private String address;

    private String dateOfBirth;
    private String phoneNumber;
    private String emailAddress;
    private String gender;
    private String volunteerAvailability;
    private String skillSet;

    private LocalDate volunteerRegistrationDate;


//    private VolunteerPersonalDetails personalDetails;
//    private VolunteerContactDetails contactDetails;
}
