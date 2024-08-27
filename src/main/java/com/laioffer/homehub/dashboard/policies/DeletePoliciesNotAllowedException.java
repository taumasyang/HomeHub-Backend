package com.laioffer.homehub.dashboard.policies;

public class DeletePoliciesNotAllowedException extends RuntimeException{
    public DeletePoliciesNotAllowedException(long userId, long newsId) {
        super("User " + userId + " not allow to delete the policy" +" "+ newsId);
    }
}
