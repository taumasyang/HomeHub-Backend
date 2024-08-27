package com.laioffer.homehub.dashboard.alerts;

import com.laioffer.homehub.model.AlertsDto;
import com.laioffer.homehub.model.CreateAlertRequest;
import com.laioffer.homehub.model.UserEntity;
import com.laioffer.homehub.model.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/Alerts")
public class AlertsController {

    private final AlertsService alertsService;

    public AlertsController(AlertsService alertService) {
        this.alertsService = alertService;
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<AlertsDto> getAllAlerts() {
        return alertsService.findAllAlerts();
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<AlertsDto> getAlertsByDate(java.time.LocalDateTime updateTime) {
        return alertsService.findAlertsByDate(updateTime);
    }

    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void createAlert(@org.springframework.security.core.annotation.AuthenticationPrincipal UserEntity user, @org.springframework.web.bind.annotation.RequestBody CreateAlertRequest body) {
        alertsService.createAlert(body.title(), body.content(), body.updateTime(), user.getId());
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/{alertId}")
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteAlert(@org.springframework.security.core.annotation.AuthenticationPrincipal UserEntity user, @org.springframework.web.bind.annotation.PathVariable long alertId) {
        alertsService.deleteAlert(user.getId(), alertId);
    }
}


