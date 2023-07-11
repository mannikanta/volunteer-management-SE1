package com.volunteer.management.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Volunteer {
    // volunteer Id should be of length 8 and it should be unique and it should contain alphabets and digits
    @Id
    @Column(name = "volunteerId", nullable = false)
    private String volunteerId;

    @OneToOne(mappedBy = "volunteerId", cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_details_id")
    private VolunteerPersonalDetails personalDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_details_id")
    private VolunteerContactDetails contactDetails;
}
