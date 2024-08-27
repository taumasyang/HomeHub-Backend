package com.laioffer.homehub.repository.dashboard;

import com.laioffer.homehub.model.AlertsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;


public interface AlertsRepository extends org.springframework.data.jpa.repository.JpaRepository<AlertsEntity, Long> {

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM alerts WHERE updateTime >= :currentDate order by updateTime des", nativeQuery = true)
    java.util.List<AlertsEntity> findAllByDate(LocalDateTime date);

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM alerts order by updateTime", nativeQuery = true)
    java.util.List<AlertsEntity> findAllAlerts();

    boolean existsByAlertId(long alertId);
}
