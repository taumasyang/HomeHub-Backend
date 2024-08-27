package com.laioffer.homehub.repository.dashboard;

import com.laioffer.homehub.model.PoliciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;


public interface PoliciesRepository extends org.springframework.data.jpa.repository.JpaRepository<com.laioffer.homehub.model.PoliciesEntity, Long> {

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM policies WHERE updateTime >= :currentDate order by updateTime des", nativeQuery = true)
    java.util.List<com.laioffer.homehub.model.PoliciesEntity> findAllByDate(java.time.LocalDateTime date);

    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM policies order by updateTime", nativeQuery = true)
    java.util.List<com.laioffer.homehub.model.PoliciesEntity> findAllPolicies();

    boolean existsByPolicyId(long policyId);
}
