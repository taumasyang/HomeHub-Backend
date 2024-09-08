package com.laioffer.homehub.discussBoard;

import com.laioffer.homehub.db.entity.CommentEntity;

public record CommentDto(
    String commentId,
    String discussId,
    String userId,
    String content,
    String commentTime
) {
  public CommentDto(CommentEntity commentEntity) {
    this(commentEntity.commentId(), commentEntity.discussId(), commentEntity.userId(),
        commentEntity.content(), commentEntity.commentTime());
  }
}
