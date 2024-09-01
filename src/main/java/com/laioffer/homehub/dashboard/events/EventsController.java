package com.laioffer.homehub.dashboard.events;

import com.laioffer.homehub.model.EventsDto;
import com.laioffer.homehub.model.CreateEventRequest;
import com.laioffer.homehub.model.UserEntity;
import com.laioffer.homehub.model.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/Events")
public class EventsController {

    private final com.laioffer.homehub.dashboard.events.EventsService eventsService;

    public EventsController(com.laioffer.homehub.dashboard.events.EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<com.laioffer.homehub.model.EventsDto> getAllEvents() {
        return eventsService.findAllEvents();
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<com.laioffer.homehub.model.EventsDto> getEventsByDate(java.time.LocalDateTime updateTime) {
        return eventsService.findEventsByDate(updateTime);
    }

    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void createEvent(@org.springframework.security.core.annotation.AuthenticationPrincipal com.laioffer.homehub.model.UserEntity user, @org.springframework.web.bind.annotation.RequestBody com.laioffer.homehub.model.CreateEventRequest body) {
        eventsService.createEvent(body.title(), body.content(), body.eventTime(), body.updateTime(), user.getId());
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/{eventId}")
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteEvent(@org.springframework.security.core.annotation.AuthenticationPrincipal com.laioffer.homehub.model.UserEntity user, @org.springframework.web.bind.annotation.PathVariable long eventId) {
        eventsService.deleteEvent(user.getId(), eventId);
    }
}


