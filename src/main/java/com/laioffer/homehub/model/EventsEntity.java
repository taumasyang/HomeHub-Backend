package com.laioffer.homehub.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "events")
public class EventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime eventTime;
    private LocalDateTime updateTime;
    private Long publisherId;

    public EventsEntity() {
    }

    public EventsEntity(Long id, String title, String content, LocalDateTime eventTime, LocalDateTime updateTime, Long publisherId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.eventTime = eventTime;
        this.updateTime = updateTime;
        this.publisherId = publisherId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() { return title; }

    public String getContent() { return content; }

    public LocalDateTime getEventTime() { return eventTime; }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Long getPublisherId() { return publisherId; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsEntity that = (EventsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(updateTime, that.updateTime) && Objects.equals(publisherId, that.publisherId);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, eventTime, updateTime, publisherId);
    }


    @Override
    public String toString() {
        return "EventsEntity{" +
                "id=" + id +
                ", title=" + title +
                ", content=" + content +
                ", eventTime=" + eventTime +
                ", updateTime=" + updateTime +
                ", publisherId=" + publisherId +
                '}';
    }
}
