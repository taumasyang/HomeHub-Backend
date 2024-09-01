package com.laioffer.homehub.repository.dashboard;

import com.laioffer.homehub.model.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;


public interface EventsRepository extends org.springframework.data.jpa.repository.JpaRepository<EventsEntity, Long> {

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM events WHERE eventTime >= :currentDate order by eventTime desc", nativeQuery = true)
    java.util.List<EventsEntity> findAllByDate(java.time.LocalDateTime date);

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM events order by eventTime", nativeQuery = true)
    java.util.List<EventsEntity> findAllEvents();

    boolean existsByEventId(long eventId);
}
