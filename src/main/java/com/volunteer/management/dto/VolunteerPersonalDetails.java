package com.volunteer.management.dto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "VolunteerPersonalDetails")
public class VolunteerPersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personal_details_id;

    @OneToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteerId;

    @Column(name = "volunteerFirstName")
    private String volunteerFirstName;

    @Column(name = "volunteerLastName")
    private String volunteerLastName;

    @Column(name = "address")
    private String address;
}
