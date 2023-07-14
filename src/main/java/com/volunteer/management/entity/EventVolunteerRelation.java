/*
package com.volunteer.management.entity;

import javax.persistence.*;

@Entity(name = "EventVolunteer")
public class EventVolunteerRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "volunteerId")
    private Volunteer volunteerId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventName")
    private Event eventName;

}
*/
