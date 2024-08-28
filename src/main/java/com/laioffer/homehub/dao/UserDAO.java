package com.laioffer.homehub.dao;

import com.laioffer.homehub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User queryUser(String name, String password) {
        String sql = "SELECT id, name, password FROM user WHERE name = ? AND password = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name, password}, new UserRowMapper());
    }

    public User queryUserByName(String name) {
        String sql = "SELECT id, name, password FROM user WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserRowMapper());
    }

    public void insertUser(String name, String password) {
        String sql = "INSERT INTO user (name, password) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, password);
    }

    public User getUserByName(String name) {
        String sql = "SELECT * FROM user WHERE name = ? LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }
}
