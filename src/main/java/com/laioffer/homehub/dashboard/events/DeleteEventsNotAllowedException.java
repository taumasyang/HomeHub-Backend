package com.laioffer.homehub.dashboard.events;

public class DeleteEventsNotAllowedException extends RuntimeException{
    public DeleteEventsNotAllowedException(long userId, long alertId) {
        super("User " + userId + " not allow to delete the event" +" "+ alertId);
    }
}
