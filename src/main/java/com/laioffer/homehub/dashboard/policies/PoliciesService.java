package com.laioffer.homehub.dashboard.policies;

import com.laioffer.homehub.model.PoliciesDto;
import com.laioffer.homehub.model.PoliciesEntity;
import com.laioffer.homehub.repository.dashboard.PoliciesRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class PoliciesService {
    private final PoliciesRepository policiesRepository;

    public PoliciesService(PoliciesRepository policiesRepository) {
        this.policiesRepository = policiesRepository;
    }


    public java.util.List<com.laioffer.homehub.model.PoliciesDto> findPoliciesByDate(java.time.LocalDateTime date) {
        return policiesRepository.findAllByDate(date)
                .stream()
                .map(com.laioffer.homehub.model.PoliciesDto::new)
                .toList();
    }

    public java.util.List<com.laioffer.homehub.model.PoliciesDto> findAllPolicies() {
        return policiesRepository.findAll()
                .stream()
                .map(com.laioffer.homehub.model.PoliciesDto::new)
                .toList();
    }


    public void createPolicy(String title, String content, java.time.LocalDateTime updateTime, long publisherId) {
        //add later: if publisher is not Admin, throw exception

        policiesRepository.save(new com.laioffer.homehub.model.PoliciesEntity(null, title, content, updateTime, publisherId));
    }

    public void deletePolicy(long userId, long newsId) {
        //add later: if policy does not exit or user is not ADMIN, throw exception
        //if ()
        //{
        //    throw new DeleteEventsNotAllowedException(userId, alertId);
        //}

        policiesRepository.deleteById(newsId);
    }

    public boolean existsPolicy(long policyId) {
        return policiesRepository.existsByPolicyId(policyId);
    }
}


