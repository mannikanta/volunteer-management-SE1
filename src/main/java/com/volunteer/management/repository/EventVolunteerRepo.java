package com.volunteer.management.repository;

import com.volunteer.management.entity.EventVolunteerRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventVolunteerRepo extends JpaRepository<EventVolunteerRelation, Long> {
}
