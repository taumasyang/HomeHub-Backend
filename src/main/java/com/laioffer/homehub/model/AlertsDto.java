package com.laioffer.homehub.model;

public record AlertsDto(
        Long id,
        String title,
        String content,
        java.time.LocalDateTime updateTime,
        Long publisherId

) {
    public AlertsDto(AlertsEntity entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getUpdateTime(),
                entity.getPublisherId()
        );
    }
}

