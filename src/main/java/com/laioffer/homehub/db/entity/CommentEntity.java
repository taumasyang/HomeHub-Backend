package com.laioffer.homehub.db.entity;

public record CommentEntity(
    String commentId,
    String discussId,
    String userId,
    String content,
    String commentTime
) { }
