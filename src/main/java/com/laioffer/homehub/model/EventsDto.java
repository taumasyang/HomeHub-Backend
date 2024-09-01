package com.laioffer.homehub.model;

import java.time.LocalDateTime;

public record EventsDto(
        Long id,
        String title,
        String content,
        java.time.LocalDateTime eventTime,
        java.time.LocalDateTime updateTime,
        Long publisherId

) {
    public EventsDto(EventsEntity entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getEventTime(),
                entity.getUpdateTime(),
                entity.getPublisherId()
        );
    }
}

