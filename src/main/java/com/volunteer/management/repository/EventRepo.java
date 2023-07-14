package com.volunteer.management.repository;

import com.volunteer.management.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, String> {

     Event findByEventName(String eventName);
}
