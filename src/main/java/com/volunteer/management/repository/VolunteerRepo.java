package com.volunteer.management.repository;

import com.volunteer.management.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepo extends JpaRepository<Volunteer, String> {
    Volunteer findByVolunteerId(String volunteerId);
}
