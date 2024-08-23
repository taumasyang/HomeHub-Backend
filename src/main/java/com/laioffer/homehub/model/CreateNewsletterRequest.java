package com.laioffer.homehub.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record CreateNewsletterRequest(
        long id,
        String title,
        String content,
        LocalDateTime updateTime,
        long publisherId
) {
}
