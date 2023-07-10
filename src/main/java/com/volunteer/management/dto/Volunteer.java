package com.volunteer.management.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Volunteer {
    // volunteer Id should be of length 8 and it should be unique and it should contain alphabets and digits
    private String volunteerId;
    private String volunteerFirstName;
    private String volunteerLastName;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String gender;
}
