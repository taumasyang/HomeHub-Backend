package com.laioffer.homehub.discussBoard;

import com.laioffer.homehub.db.CommentRepository;
import com.laioffer.homehub.db.DiscussRepository;
import com.laioffer.homehub.db.entity.CommentEntity;
import com.laioffer.homehub.db.entity.DiscussEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DiscussService {
    private final DiscussRepository discussRepository;
    private final CommentRepository commentRepository;

    public DiscussService(DiscussRepository discussRepository, CommentRepository commentRepository) {
        this.discussRepository = discussRepository;
        this.commentRepository = commentRepository;
    }

    public void createDiscuss(
        String userId,
        String content,
        String time
    ) {
        DiscussEntity discussEntity = new DiscussEntity(
            null,
            userId,
            content,
            //LocalDateTime.now().toString(),
            time,
            new ArrayList<>()
        );
        discussRepository.save(discussEntity);
    }

    public void createComment(
        String discussId,
        String userId,
        String content
    ) {
        // String commentId = UUID.randomUUID().toString();
        CommentEntity commentEntity = new CommentEntity(
            null,
            discussId,
            userId,
            content,
            LocalDateTime.now().toString()
        );
        commentRepository.save(commentEntity);
        discussRepository.addComment(discussId, commentEntity.commentId());
    }

    public List<DiscussDto> getAllDiscusses() {
        return discussRepository.findAll().stream()
            .map(DiscussDto::new)
            .toList();
    }

    public List<CommentEntity> getCommentsByDiscussId(String discussId) {
        return commentRepository.findAllByDiscussId(discussId);
    }

    public void deleteDiscuss(String discussId) {
        discussRepository.delete(discussId);
    }

    public void deleteComment(String discussId, String commentId) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentId);
        discussRepository.removeComment(discussId, commentId);
        commentRepository.delete(commentId);
    }

}
