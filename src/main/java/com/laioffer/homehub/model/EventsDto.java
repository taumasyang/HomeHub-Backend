package com.laioffer.homehub.model;

public record EventsDto(
        Long id,
        String title,
        String content,
        java.time.LocalDateTime updateTime,
        Long publisherId

) {
    public EventsDto(EventsEntity entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getUpdateTime(),
                entity.getPublisherId()
        );
    }
}

