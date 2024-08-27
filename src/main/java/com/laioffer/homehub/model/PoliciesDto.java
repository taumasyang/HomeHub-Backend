package com.laioffer.homehub.model;

public record PoliciesDto(
        Long id,
        String title,
        String content,
        java.time.LocalDateTime updateTime,
        Long publisherId

) {
    public PoliciesDto(PoliciesEntity entity) {
        this(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getUpdateTime(),
                entity.getPublisherId()
        );
    }
}

