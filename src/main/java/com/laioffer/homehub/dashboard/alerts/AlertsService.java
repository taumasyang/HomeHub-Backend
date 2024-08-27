package com.laioffer.homehub.dashboard.alerts;

import com.laioffer.homehub.model.AlertsDto;
import com.laioffer.homehub.model.AlertsEntity;
import com.laioffer.homehub.repository.dashboard.AlertsRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class AlertsService {
    private final AlertsRepository alertsRepository;

    public AlertsService(
            AlertsRepository alertsRepository
    ) {
        this.alertsRepository = alertsRepository;
    }


    public java.util.List<AlertsDto> findAlertsByDate(LocalDateTime date) {
        return alertsRepository.findAllByDate(date)
                .stream()
                .map(AlertsDto::new)
                .toList();
    }

    public java.util.List<AlertsDto> findAllAlerts() {
        return alertsRepository.findAll()
                .stream()
                .map(AlertsDto::new)
                .toList();
    }


    public void createAlert(String title, String content, java.time.LocalDateTime updateTime, long publisherId) {
        //add later: if publisher is not Admin, throw exception
        alertsRepository.save(new AlertsEntity(null, title, content, updateTime, publisherId));
    }

    public void deleteAlert(long userId, long alertId) {
        //add later: if alert does not exit or user is not ADMIN, throw exception
        //if ()
        //{
        //    throw new DeleteAlertsNotAllowedException(userId, alertId);
        //}

        alertsRepository.deleteById(alertId);
    }

    public boolean existsAlerts(long alertId) {
        return alertsRepository.existsByAlertId(alertId);
    }
}

