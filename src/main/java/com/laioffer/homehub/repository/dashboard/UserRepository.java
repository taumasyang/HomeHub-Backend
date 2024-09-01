package com.laioffer.homehub.repository.dashboard;


import com.laioffer.homehub.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<UserEntity, Long> {


    UserEntity findByUsername(String username);


    boolean existsByUsername(String username);
}
