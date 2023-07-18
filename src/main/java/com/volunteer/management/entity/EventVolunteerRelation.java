package com.volunteer.management.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "eventVolunteer")
public class EventVolunteerRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "volunteerId")
    private String volunteerId;

    @Column(name = "eventName")
    private String eventName;

}
//
//@Entity
//@Table(name = "volunteer_event",
//        uniqueConstraints = @UniqueConstraint(columnNames = {"volunteer_id", "event_id"}))
//public class VolunteerEvent {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "volunteer_id", nullable = false)
//    private Volunteer volunteer;
//
//    @ManyToOne
//    @JoinColumn(name = "event_id", nullable = false)
//    private Event event;
//
//    // other fields, getters, setters
//}
