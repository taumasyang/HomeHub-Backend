package com.laioffer.homehub.dashboard.alerts;

public class DeleteAlertsNotAllowedException extends RuntimeException{
    public DeleteAlertsNotAllowedException(long userId, long alertId) {
        super("User " + userId + " not allow to delete the alert" +" "+ alertId);
    }
}
