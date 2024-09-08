package com.laioffer.homehub.discussBoard;

import com.laioffer.homehub.db.entity.DiscussEntity;

public record DiscussDto(
    String discussId,
    String userId,
    String discussTitle,
    String discussContent,
    String discussTime
) {
  public DiscussDto(DiscussEntity discussEntity) {
    this(discussEntity.discussId(), discussEntity.userId(), discussEntity.discussTitle(),
        discussEntity.discussContent(), discussEntity.discussTime());
  }

}
