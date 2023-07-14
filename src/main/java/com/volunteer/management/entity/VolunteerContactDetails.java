package com.volunteer.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "gender")
    private String gender;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "availability")
    private java.util.Date volunteerAvailability;

    @ElementCollection
    private List<String> skillSet;

}
