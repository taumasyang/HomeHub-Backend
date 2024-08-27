package com.laioffer.homehub.dashboard.policies;

import com.laioffer.homehub.model.PoliciesDto;
import com.laioffer.homehub.dashboard.policies.PoliciesService;
import com.laioffer.homehub.model.CreateAlertRequest;
import com.laioffer.homehub.model.UserEntity;
import com.laioffer.homehub.model.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/Policies")
public class PoliciesController {

    private final com.laioffer.homehub.dashboard.policies.PoliciesService policiesService;

    public PoliciesController(PoliciesService policiesService) {
        this.policiesService = policiesService;
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<com.laioffer.homehub.model.PoliciesDto> getAllPolicies() {
        return policiesService.findAllPolicies();
    }

    @org.springframework.web.bind.annotation.GetMapping
    public java.util.List<com.laioffer.homehub.model.PoliciesDto> getPoliciesByDate(java.time.LocalDateTime updateTime) {
        return policiesService.findPoliciesByDate(updateTime);
    }

    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void createPolicy(@org.springframework.security.core.annotation.AuthenticationPrincipal com.laioffer.homehub.model.UserEntity user, @org.springframework.web.bind.annotation.RequestBody com.laioffer.homehub.model.CreateAlertRequest body) {
        policiesService.createPolicy(body.title(), body.content(), body.updateTime(), user.getId());
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/{newsId}")
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deletePolicy(@org.springframework.security.core.annotation.AuthenticationPrincipal com.laioffer.homehub.model.UserEntity user, @org.springframework.web.bind.annotation.PathVariable long policyId) {
        policiesService.deletePolicy(user.getId(), policyId);
    }
}


