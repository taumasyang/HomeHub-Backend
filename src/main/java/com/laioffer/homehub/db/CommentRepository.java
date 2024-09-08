package com.laioffer.homehub.db;

import com.laioffer.homehub.db.entity.CommentEntity;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public interface CommentRepository extends ListCrudRepository<CommentEntity, String> {

  List<CommentEntity> findAllByDiscussId(String discussId);

  boolean delete(String commentId);
}
