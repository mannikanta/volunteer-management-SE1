package com.volunteer.management.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EventVolunteerMatchDto {

    private String eventName;

    // before Event creation Date or after creation date
    // this should be a radio button
    private String sortVolunteersbyDate;

}


