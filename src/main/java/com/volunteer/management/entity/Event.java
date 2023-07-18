package com.volunteer.management.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eventName", nullable = false,unique = true)
    private String eventName;

    @Column(name = "eventDescription", nullable = false)
    private String eventDescription;

    @Column(name = "eventLocation")
    private String eventLocation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "eventCreationDate")
    private LocalDate eventCreationDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "eventDate")
    private Date eventDateTime;

    @Column(name = "eventDuration")
    private short eventDuration;

    @Column(name = "volunteerStatus")
    private boolean isVolunteer;

//    @OneToMany(cascade = CascadeType.ALL)
//    private EventVolunteerRelation eventVolunteerRelation;
}
