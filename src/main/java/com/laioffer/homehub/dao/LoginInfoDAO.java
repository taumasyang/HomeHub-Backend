package com.laioffer.homehub.dao;

import com.laioffer.homehub.model.LoginInfoDo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginInfoDAO {

    private final JdbcTemplate jdbcTemplate;

    public LoginInfoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addLoginInfo(LoginInfoDo loginInfoDo) {
        String sql = "INSERT INTO login_info (user_id, user_name, status, create_time) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                loginInfoDo.getUserId(),
                loginInfoDo.getUserName(),
                loginInfoDo.getStatus(),
                loginInfoDo.getCreateTime());
    }
}

