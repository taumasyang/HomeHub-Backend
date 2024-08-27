package com.laioffer.homehub.repository.dashboard;

import com.laioffer.homehub.model.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;


public interface NewsletterRepository extends org.springframework.data.jpa.repository.JpaRepository<com.laioffer.homehub.model.NewsletterEntity, Long> {

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM news WHERE updateTime >= :currentDate order by updateTime des", nativeQuery = true)
    java.util.List<com.laioffer.homehub.model.NewsletterEntity> findAllByDate(java.time.LocalDateTime date);

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM news order by updateTime", nativeQuery = true)
    java.util.List<com.laioffer.homehub.model.NewsletterEntity> findAllEvents();

    boolean existsByNewsId(long newsId);
}
