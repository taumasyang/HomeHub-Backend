package com.laioffer.homehub.db;

import com.laioffer.homehub.db.entity.DiscussEntity;
import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

public interface DiscussRepository extends ListCrudRepository<DiscussEntity, String> {
  // boolean save(DiscussEntity discussEntity);
  // DiscussEntity findById(String discussId);
  // List<DiscussEntity> findAll();
  boolean delete(String discussId);
  boolean addComment(String discussId, String commentId);
  boolean removeComment(String discussId, String commentId);
}
