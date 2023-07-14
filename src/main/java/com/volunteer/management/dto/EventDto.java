package com.volunteer.management.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EventDto {

    private Long id;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private LocalDate eventCreationDate;
    private String eventDateTime;
    private short eventDuration;
    private String existingVolunteer;

}
