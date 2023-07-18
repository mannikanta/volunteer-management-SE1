package com.volunteer.management.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VolunteerEventEnrollmentDto {

    private String volunteerId;
    private String eventName;
}
