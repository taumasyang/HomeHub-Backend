package com.laioffer.homehub.model;

public record NewsletterDto(
        Long id,
        String title,
        String content,
        java.time.LocalDateTime updateTime,
        Long publisherId

) {
    public NewsletterDto(NewsletterEntity entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getUpdateTime(),
                entity.getPublisherId()
        );
    }
}

