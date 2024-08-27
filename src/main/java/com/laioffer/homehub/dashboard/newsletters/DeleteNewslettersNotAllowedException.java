package com.laioffer.homehub.dashboard.newsletters;

public class DeleteNewslettersNotAllowedException extends RuntimeException{
    public DeleteNewslettersNotAllowedException(long userId, long newsId) {
        super("User " + userId + " not allow to delete the news" +" "+ newsId);
    }
}
