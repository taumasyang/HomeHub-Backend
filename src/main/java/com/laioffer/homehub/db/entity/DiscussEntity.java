package com.laioffer.homehub.db.entity;

import java.util.List;

public record DiscussEntity(
    String discussId,
    String userId,
    String discussTitle,
    String discussContent,
    String discussTime,
    List<CommentEntity> comments
) { }
