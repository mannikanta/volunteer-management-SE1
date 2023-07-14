package com.volunteer.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Volunteer {
    // volunteer Id should be of length 8 and it should be unique and it should contain alphabets and digits
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "volunteer_Id", nullable = false,unique = true)
    private String volunteerId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "volunteerCreationDate")
    private LocalDate volunteerRegistrationDate;


    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="personal_details_id")
    private  VolunteerPersonalDetails personalDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_details_id")
    private VolunteerContactDetails contactDetails;

    @OneToOne
    @JoinColumn(name = "eventName")
    private Event event;


    /*@OneToOne(mappedBy = "volunteer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="personal_details_id")
    private  VolunteerPersonalDetails personalDetails;

    @OneToOne(mappedBy = "volunteer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_details_id")
    private VolunteerContactDetails contactDetails;*/

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "volunteer_personal_details_id")
    private VolunteerPersonalDetails personalDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "volunteer_contact_details_id")
    private VolunteerContactDetails contactDetails;*/

}
