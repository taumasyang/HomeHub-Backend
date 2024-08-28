package com.laioffer.homehub.dao;

import com.laioffer.homehub.model.MessageRecordDo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRecordDAO {

    private final JdbcTemplate jdbcTemplate;
    public MessageRecordDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addMessageRecord(MessageRecordDo messageRecordDo) {
        String sql = "INSERT INTO message_record (user_id, user_name, message_type, content, create_time) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                messageRecordDo.getUserId(),
                messageRecordDo.getUserName(),
                messageRecordDo.getMessageType(),
                messageRecordDo.getContent(),
                messageRecordDo.getCreateTime());
    }
}

