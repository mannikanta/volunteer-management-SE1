package com.volunteer.management.dto;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "contact_details")
public class VolunteerContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_details_id")
    private Long id;

    @OneToOne(mappedBy = "contactDetails",fetch = FetchType.LAZY)
//    @JoinColumn(name = "volunteer_Id")
    private Volunteer volunteer;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "gender")
    private String gender;
}
