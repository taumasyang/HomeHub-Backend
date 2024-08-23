package com.laioffer.homehub.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record CreatePolicyRequest(
        long id,
        String title,
        String content,
        LocalDateTime updateTime,
        long publisherId
) {
}
