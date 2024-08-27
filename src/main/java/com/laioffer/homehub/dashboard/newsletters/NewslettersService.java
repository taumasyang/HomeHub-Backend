package com.laioffer.homehub.dashboard.newsletters;

import com.laioffer.homehub.model.NewsletterDto;
import com.laioffer.homehub.model.NewsletterEntity;
import com.laioffer.homehub.repository.dashboard.NewsletterRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class NewslettersService {
    private final NewsletterRepository newsletterRepository;

    public NewslettersService(
            NewsletterRepository newsletterRepository
    ) {
        this.newsletterRepository = newsletterRepository;
    }


    public java.util.List<NewsletterDto> findNewsByDate(java.time.LocalDateTime date) {
        return newsletterRepository.findAllByDate(date)
                .stream()
                .map(com.laioffer.homehub.model.NewsletterDto::new)
                .toList();
    }

    public java.util.List<NewsletterDto> findAllNews() {
        return newsletterRepository.findAll()
                .stream()
                .map(com.laioffer.homehub.model.NewsletterDto::new)
                .toList();
    }


    public void createNews(String title, String content, java.time.LocalDateTime updateTime, long publisherId) {
        //add later: if publisher is not Admin, throw exception

        newsletterRepository.save(new com.laioffer.homehub.model.NewsletterEntity(null, title, content, updateTime, publisherId));
    }

    public void deleteNews(long userId, long newsId) {
        //add later: if event does not exit or user is not ADMIN, throw exception
        //if ()
        //{
        //    throw new DeleteEventsNotAllowedException(userId, alertId);
        //}

        newsletterRepository.deleteById(newsId);
    }

    public boolean existsAlerts(long newsId) {
        return newsletterRepository.existsByNewsId(newsId);
    }
}


