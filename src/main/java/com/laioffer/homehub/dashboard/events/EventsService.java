package com.laioffer.homehub.dashboard.events;

import com.laioffer.homehub.model.EventsDto;
import com.laioffer.homehub.model.EventsEntity;
import com.laioffer.homehub.repository.dashboard.AlertsRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class EventsService {
    private final com.laioffer.homehub.repository.dashboard.EventsRepository eventsRepository;

    public EventsService(
            com.laioffer.homehub.repository.dashboard.EventsRepository eventsRepository
    ) {
        this.eventsRepository = eventsRepository;
    }


    public java.util.List<EventsDto> findEventsByDate(java.time.LocalDateTime date) {
        return eventsRepository.findAllByDate(date)
                .stream()
                .map(com.laioffer.homehub.model.EventsDto::new)
                .toList();
    }

    public java.util.List<EventsDto> findAllEvents() {
        return eventsRepository.findAll()
                .stream()
                .map(com.laioffer.homehub.model.EventsDto::new)
                .toList();
    }


    public void createEvent(String title, String content, java.time.LocalDateTime eventTime, java.time.LocalDateTime updateTime, long publisherId) {
        //add later: if publisher is not Admin, throw exception

        eventsRepository.save(new com.laioffer.homehub.model.EventsEntity(null, title, content, eventTime, updateTime,  publisherId));
    }

    public void deleteEvent(long userId, long eventId) {
        //add later: if event does not exit or user is not ADMIN, throw exception
        //if ()
        //{
        //    throw new DeleteEventsNotAllowedException(userId, alertId);
        //}

        eventsRepository.deleteById(eventId);
    }

    public boolean existsAlerts(long eventId) {
        return eventsRepository.existsByEventId(eventId);
    }
}

