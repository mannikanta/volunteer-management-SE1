package com.volunteer.management.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EventVolunteer {

    private String eventName;

    // before Event creation Date or after creation date
    // this should be a radio button
    private String sortVolunteers;

}
