package com.laioffer.homehub.dashboard.newsletters;

import com.laioffer.homehub.model.NewsletterDto;
import com.laioffer.homehub.model.CreateAlertRequest;
import com.laioffer.homehub.model.UserEntity;
import com.laioffer.homehub.model.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/Newsletter")
public class NewslettersController {

    private final com.laioffer.homehub.dashboard.newsletters.NewslettersService newslettersService;

    public NewslettersController(com.laioffer.homehub.dashboard.newsletters.NewslettersService newslettersService) {
        this.newslettersService = newslettersService;
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<NewsletterDto> getAllNews() {
        return newslettersService.findAllNews();
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<NewsletterDto> getNewsByDate(java.time.LocalDateTime updateTime) {
        return newslettersService.findNewsByDate(updateTime);
    }

    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void createAlert(@org.springframework.security.core.annotation.AuthenticationPrincipal com.laioffer.homehub.model.UserEntity user, @org.springframework.web.bind.annotation.RequestBody com.laioffer.homehub.model.CreateAlertRequest body) {
        newslettersService.createNews(body.title(), body.content(), body.updateTime(), user.getId());
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/{newsId}")
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteNews(@org.springframework.security.core.annotation.AuthenticationPrincipal com.laioffer.homehub.model.UserEntity user, @org.springframework.web.bind.annotation.PathVariable long newsId) {
        newslettersService.deleteNews(user.getId(), newsId);
    }
}


