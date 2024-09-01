package com.laioffer.homehub.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record CreateEventRequest(
        long id,
        String title,
        String content,
        LocalDateTime eventTime,
        LocalDateTime updateTime,
        long publisherId
) {
}
