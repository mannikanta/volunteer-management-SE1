package com.volunteer.management.dto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "personal_details")
public class VolunteerPersonalDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_details_id")
    private Long id;

    @OneToOne(mappedBy = "personalDetails")
//    @JoinColumn(name = "volunteer_Id")
    private Volunteer volunteer;

//    @OneToOne(mappedBy = "personalDetails")
//    private Volunteer volunteer;
//   // @JoinColumn(name = "volunteerId")
//    private Volunteer volunteerId;

    @Column(name = "volunteerFirstName")
    private String volunteerFirstName;

    @Column(name = "volunteerLastName")
    private String volunteerLastName;

    @Column(name = "address")
    private String address;


}
